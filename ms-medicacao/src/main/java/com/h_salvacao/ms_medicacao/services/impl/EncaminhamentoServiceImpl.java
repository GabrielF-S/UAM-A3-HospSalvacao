package com.h_salvacao.ms_medicacao.services.impl;

import com.h_salvacao.ms_medicacao.feingClient.EncaminhamentoFeingClient;
import com.h_salvacao.ms_medicacao.model.*;
import com.h_salvacao.ms_medicacao.services.AtendimentoService;
import com.h_salvacao.ms_medicacao.services.MedicacaoProducerSender;
import com.h_salvacao.ms_medicacao.services.EncaminhamentoService;
import com.h_salvacao.ms_medicacao.services.TokenService;
import com.h_salvacao.ms_medicacao.util.AtendimentoStatus;
import com.h_salvacao.ms_medicacao.util.Queue;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EncaminhamentoServiceImpl implements EncaminhamentoService {
    @Autowired
    Queue<Encaminhamento> lista;

    private final EncaminhamentoFeingClient feingClient;

    private final MedicacaoProducerSender producerSender;

    @Autowired
    AtendimentoService atendimentoService;

    @Autowired
    TokenService tokenService;

    public void adicionarFila(Encaminhamento encaminhamento){
        lista.enqueue(encaminhamento);
    }

    @Override
    public Integer getQtd() {
        return lista.size();
    }

    @Override
    public Encaminhamento getProximo() {
        Encaminhamento encaminhamento= lista.dequeue();
        Token token = feingClient.getToken(encaminhamento.getNumToken()).getBody();
        if ((token != null) && (token.getStatus() == AtendimentoStatus.MEDICACAO ||token.getStatus() == AtendimentoStatus.MED_RAIOX )){
            atendimentoService.atualizarEntradaAtendimento(token.getNumToken());
            producerSender.sendoToAtendimento(token);
            return  encaminhamento;
        }else {
            throw new RuntimeException("Token não localizado na base");
        }
    }
    @Override
    public void encaminharPaciente(Encaminhamento encaminhamento) {
        Token token = tokenService.getToken(encaminhamento.getNumToken());
        TempoAtendimento tempoAtendimento= atendimentoService.getTempoAtendimento(encaminhamento.getNumToken());
        atendimentoService.atualizarSaidaAtendimento(tempoAtendimento);
        token = tokenService.setRetorno(token);
        if (token.getStatus()== AtendimentoStatus.MEDICACAO){
            token= tokenService.setStatus(token ,AtendimentoStatus.DOUTOR);
            producerSender.sentoToMedico(token);
        } else if (token.getStatus()== AtendimentoStatus.MED_RAIOX) {
            token = tokenService.setStatus(token,AtendimentoStatus.RAIOX);
            producerSender.sendoToRaioX(encaminhamento);
        }
        tokenService.updateToken(token);
    }
    @Override
    public Queue<Encaminhamento> getLista() {
        return lista;
    }

}

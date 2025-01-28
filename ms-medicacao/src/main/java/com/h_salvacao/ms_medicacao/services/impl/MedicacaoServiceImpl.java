package com.h_salvacao.ms_medicacao.services.impl;

import com.h_salvacao.ms_medicacao.feingClient.MedicacaoFeingClient;
import com.h_salvacao.ms_medicacao.model.*;
import com.h_salvacao.ms_medicacao.services.MedicacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class MedicacaoServiceImpl implements MedicacaoService {
    @Autowired
    Queue<Encaminhamento> lista;

    private final MedicacaoFeingClient feingClient;


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
            atualizarEntradaAtendimento(token.getNumToken());
            return  encaminhamento;
        }else {
            throw new RuntimeException("Token não localizado na base");
        }

    }

    private void atualizarEntradaAtendimento(String numToken) {
        TempoAtendimento tempoAtendimento = feingClient.getTempoAtendimento(numToken);
        tempoAtendimento.setEntradaMedicacao(LocalTime.now());
        feingClient.updateAtendimento(tempoAtendimento);
    }

    private void atualizarSaidaAtendimento(TempoAtendimento tempoAtendimento) {
        tempoAtendimento.setSaidaMedicacao(LocalTime.now());
        feingClient.updateAtendimento(tempoAtendimento);
    }

    @Override
    public void encaminharPaciente(Encaminhamento encaminhamento) {
        Token token = feingClient.getToken(encaminhamento.getNumToken()).getBody();
        TempoAtendimento tempoAtendimento= feingClient.getTempoAtendimento(encaminhamento.getNumToken());
        atualizarSaidaAtendimento(tempoAtendimento);
        if (token.getStatus()== AtendimentoStatus.MEDICACAO){
            token.setStatus(AtendimentoStatus.DOUTOR);
            //TODO
            //Encaminhar para topico do doutor

        } else if (token.getStatus()== AtendimentoStatus.MED_RAIOX) {
            //TODO
            //Encaminhar para topico do raiox

        }

    }

}

package com.h_salvacao.ms_medico.service.impl;

import com.h_salvacao.ms_medico.feignCliente.EncaminhamentoFeingClient;
import com.h_salvacao.ms_medico.model.Encaminhamento;
import com.h_salvacao.ms_medico.model.TempoAtendimento;
import com.h_salvacao.ms_medico.model.Token;
import com.h_salvacao.ms_medico.service.EncaminhamentoProducerSender;
import com.h_salvacao.ms_medico.service.EncaminhamentoService;
import com.h_salvacao.ms_medico.service.TempoAtendimentoService;
import com.h_salvacao.ms_medico.service.TokenService;
import com.h_salvacao.ms_medico.util.AtendimentoStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EncaminhamentoServiceImpl implements EncaminhamentoService {
    private  final EncaminhamentoFeingClient encaminhamentoFeingClient;
    private  final EncaminhamentoProducerSender producerSender;
    @Autowired
    TokenService tokenService;
    @Autowired
    TempoAtendimentoService tempoAtendimentoService;

    @Override
    public Encaminhamento saveEncaminhamento(Encaminhamento encaminhamento) {
        return encaminhamento = encaminhamentoFeingClient.saveEncaminhamento(encaminhamento).getBody();

    }

    @Override
    public Encaminhamento getEncaminhamento(String numToken) {
        return encaminhamentoFeingClient.getEncaminhamento(numToken);
    }

    @Override
    public Encaminhamento encaminharPaciente(Encaminhamento encaminhamento) {
        Token token = tokenService.getToken(encaminhamento.getNumToken());
        TempoAtendimento atendimento= tempoAtendimentoService.getTempoAtendimento(token.getNumToken());
        if(encaminhamento.getId() == null){
            encaminhamento = saveEncaminhamento(encaminhamento);
        }else{
            encaminhamento = atualizarEncaminhamento(encaminhamento);
        }

        if (encaminhamento.getListaMedicacoes() == null) {
            token = tokenService.setStatus(token, AtendimentoStatus.RAIOX);
            producerSender.sendoToRaioX(encaminhamento);
        } else {
            if (encaminhamento.getRegioesRaiox() == null) {
                token = tokenService.setStatus(token,AtendimentoStatus.MEDICACAO);
            } else {
                token = tokenService.setStatus(token, AtendimentoStatus.MED_RAIOX);
            }
            producerSender.sentoToMedicacaoERaioX(encaminhamento);
        }
        tempoAtendimentoService.atualizarSaidaMedico(atendimento);
        tokenService.updateToken(token);
        return encaminhamento;
    }

    private Encaminhamento atualizarEncaminhamento(Encaminhamento encaminhamento) {
        return encaminhamentoFeingClient.updateEncaminhamento(encaminhamento);
    }
}

package com.h_salvacao.ms_raiox.service.impl;

import com.h_salvacao.ms_raiox.feingClient.RaioXFeingClient;
import com.h_salvacao.ms_raiox.model.*;
import com.h_salvacao.ms_raiox.service.RaioXProducerSender;
import com.h_salvacao.ms_raiox.service.RaioXService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class RaioXServiceImpl implements RaioXService {
    @Autowired
    Triagem triagem;

    private  final RaioXProducerSender producerSender;

    private final RaioXFeingClient feingClient;

    @Override
    public void adicionarFila(Encaminhamento encaminhamento) {
        triagem.adicionarFila(encaminhamento);

    }

    @Override
    public Integer getTotal() {
        return triagem.getFila().size();
    }

    @Override
    public Encaminhamento chamarProximo() {
        Encaminhamento encaminhamento = triagem.getFila().dequeue();
        String numToken = encaminhamento.getNumToken();
        Token token = feingClient.getToken(numToken).getBody();
        if (token != null && token.getStatus() == AtendimentoStatus.RAIOX){
            atualizarEntradaAtendimento(token.getNumToken());
            return  encaminhamento;
        }else {
            throw new RuntimeException("Token não localizado na base");
        }
    }

    private void atualizarEntradaAtendimento(String numToken) {
        TempoAtendimento tempoAtendimento = feingClient.getTempoAtendimento(numToken);
        tempoAtendimento.setEntradaRaioX(LocalTime.now());
        feingClient.updateAtendimento(tempoAtendimento);
    }

    @Override
    public void encaminharPaciente(Encaminhamento encaminhamento) {
        Encaminhamento enc = feingClient.getEncaminhamento(encaminhamento.getNumToken());
        if (enc == null){
            feingClient.saveEncaminhamento(encaminhamento);
        }else {
            feingClient.updateEncaminhamento(encaminhamento);
        }


        Token token = feingClient.getToken(encaminhamento.getNumToken()).getBody();
        token.setStatus(AtendimentoStatus.DOUTOR);
        token.setRetorno(true);
        feingClient.updateToken(token);
        atualizarSaidaAtendimento(token.getNumToken());
        producerSender.senToMedico(token);



    }

    private void atualizarSaidaAtendimento(String numToken) {
        TempoAtendimento tempoAtendimento = feingClient.getTempoAtendimento(numToken);
        tempoAtendimento.setSaidaRaioX(LocalTime.now());
        feingClient.updateAtendimento(tempoAtendimento);

    }
}

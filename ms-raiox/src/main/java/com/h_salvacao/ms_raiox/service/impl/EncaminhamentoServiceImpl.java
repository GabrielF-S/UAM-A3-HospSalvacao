package com.h_salvacao.ms_raiox.service.impl;

import com.h_salvacao.ms_raiox.feingClient.EncaminhamentoFeingClient;
import com.h_salvacao.ms_raiox.model.*;
import com.h_salvacao.ms_raiox.service.RaioXProducerSender;
import com.h_salvacao.ms_raiox.service.EncaminhamentoService;
import com.h_salvacao.ms_raiox.service.TempoAtendimentoService;
import com.h_salvacao.ms_raiox.service.TokenService;
import com.h_salvacao.ms_raiox.util.AtendimentoStatus;
import com.h_salvacao.ms_raiox.util.Queue;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class EncaminhamentoServiceImpl implements EncaminhamentoService {
    @Autowired
    Queue<Encaminhamento> lista;

    @Autowired
    TempoAtendimentoService tempoAtendimentoService;
    @Autowired
    TokenService tokenService;

    private final RaioXProducerSender producerSender;

    private final EncaminhamentoFeingClient encaminhamentoFeingClient;


    @Override
    public void adicionarFila(Encaminhamento encaminhamento) {
        lista.enqueue(encaminhamento);

    }

    @Override
    public Integer getTotal() {
        return lista.size();
    }

    @Override
    public Encaminhamento chamarProximo() {
        Encaminhamento encaminhamento = lista.dequeue();
        Token token = tokenService.getToken(encaminhamento.getNumToken());
        if (token != null && token.getStatus() == AtendimentoStatus.RAIOX) {
            tempoAtendimentoService.atualizarEntradaAtendimento(token.getNumToken());
            return encaminhamento;
        } else {
            throw new RuntimeException("Token não localizado na base");
        }
    }


    @Override
    public void encaminharPaciente(Encaminhamento encaminhamento) {
        Token token =  tokenService.getToken(encaminhamento.getNumToken());
        TempoAtendimento atendimento = tempoAtendimentoService.getTempoAtendimento(token.getNumToken());
        tempoAtendimentoService.atualizarSaidaAtendimento(atendimento);
        token= tokenService.setRetorno(token);
        token = tokenService.setStatus(token,AtendimentoStatus.DOUTOR);
        tokenService.updateToken(token);
        encaminhamentoFeingClient.updateEncaminhamento(encaminhamento);
        producerSender.senToMedico(token);

    }


}

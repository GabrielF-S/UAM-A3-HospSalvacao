package com.h_salvacao.ms_guiche.service.impl;

import com.h_salvacao.ms_guiche.feignCliente.GuicheFeignCliente;
import com.h_salvacao.ms_guiche.model.*;
import com.h_salvacao.ms_guiche.service.GuicheProducerSender;
import com.h_salvacao.ms_guiche.service.GuicheService;
import com.h_salvacao.ms_guiche.service.TempoAtendimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class GuicheServiceImpl implements GuicheService {
    @Autowired
    Triagem triagem;

    @Autowired
    TempoAtendimentoService atendimentoService;

    private final GuicheProducerSender producerSender;

    private final GuicheFeignCliente guicheFeignCliente;

    @Override
    public void adicionarFila(Token token) {
        triagem.adicionarFila(token);

    }

    @Override
    public Integer pegarTotal(){
        return  triagem.getFila().size();
    }

    @Override
    public Token chamarProximo() {
        try {
            String numToken = triagem.getFila().dequeue().getNumToken();
            Token token = guicheFeignCliente.getToken(numToken).getBody();
            if (token != null && token.getStatus() == AtendimentoStatus.GUICHE){
                producerSender.sendoToAtendimento(token);
                TempoAtendimento tempoAtendimento =  guicheFeignCliente.getTempoAtendimento(numToken);
                atendimentoService.atualizarEntradaAtendimento(tempoAtendimento);
                return token;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


            return new Token(0L,"0", LocalDateTime.now(), null, AtendimentoStatus.DESCONHECIDO, TipoAtendimento.DESCONHECIDO, false);
    }

    @Override
    public Paciente salvarPaciente(Paciente paciente) {
        return guicheFeignCliente.salvarPaciente(paciente);
    }

    @Override
    public Paciente atualizarPaciente(Paciente paciente) {
        return guicheFeignCliente.atualizarPaciente(paciente);
    }

    @Override
    public Token encaminharToken(Token token) {
        token.setStatus(AtendimentoStatus.DOUTOR);
        Token tokenLocal = guicheFeignCliente.updateToken(token);
        TempoAtendimento atendimento = guicheFeignCliente.getTempoAtendimento(tokenLocal.getNumToken());
        atendimentoService.atualizarSaidaAtendimento(atendimento);
        producerSender.send(tokenLocal);
        return  tokenLocal;
    }
}

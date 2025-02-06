package com.h_salvacao.ms_triagem.service.impl;

import com.h_salvacao.ms_triagem.feignCliente.TokenFeignClient;
import com.h_salvacao.ms_triagem.model.*;
import com.h_salvacao.ms_triagem.service.TokenProducerSender;
import com.h_salvacao.ms_triagem.service.TokenService;
import com.h_salvacao.ms_triagem.util.AtendimentoStatus;
import com.h_salvacao.ms_triagem.util.Queue;
import com.h_salvacao.ms_triagem.util.TipoAtendimento;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@Service
public class TokenServiceImpl implements TokenService {

    Queue<Token> filaComum = new Queue<>();

    Queue<Token> filaPreferencial = new Queue<>();

    Queue<Token> filaUrgente = new Queue<>();

    @Autowired
    TempoAtendimentoServiceImpl atendimentoService;

    private final TokenProducerSender tokenProducerSender;
    private final TokenFeignClient tokenFeignClient;

    @Override
    public void adcionarFila(Token token) {
        switch (token.getAtendimento()) {
            case COMUM -> {
                filaComum.enqueue(token);
                break;
            }
            case PREFERENCIAL -> {
                filaPreferencial.enqueue(token);
                break;
            }
            case URGENTE -> {
                filaUrgente.enqueue(token);
                break;
            }
        }
    }

    @Override
    public Integer pegarTotal() {
        return filaComum.size() + filaPreferencial.size() + filaUrgente.size();
    }

    @Override
    public Token chamarProximo() {
        Token proximo = getProximo();
        TempoAtendimento atendimento = atendimentoService.getTempoAtendimento(proximo.getNumToken());
        atendimentoService.atualizarEntradaAtendimento(atendimento);
        tokenProducerSender.sendoToAtendimento(proximo);
        return proximo;
    }

    @Override
    public void sendToken(Token token) {
        tokenProducerSender.sendToken(token);

    }

    @Override
    public Token setStatus(Token token, AtendimentoStatus atendimentoStatus) {
       token.setStatus(atendimentoStatus);
        return token;
    }

    @Override
    public void updateToken(Token token) {
        tokenFeignClient.updateToken(token);
    }

    private Token getProximo() {
        if (pegarTotal() > 0) {
            String numToken = verificarFilas().getNumToken();
            Token token = tokenFeignClient.getToken(numToken).getBody();
            if (token != null && token.getStatus() == AtendimentoStatus.TRIAGEM) {
                return token;
            } else {
                return getProximo();
            }
        }
        return new Token(0L,"0", LocalDateTime.now(), null, AtendimentoStatus.DESCONHECIDO, TipoAtendimento.DESCONHECIDO, false
        );
    }

    private Token verificarFilas() {
        Token tokenComum, tokenPreferencial;
        if (filaUrgente.checkFirst() != null) {
            return filaUrgente.dequeue();
        }
        if (filaPreferencial.checkFirst() == null && filaComum.checkFirst() != null) {
            return filaComum.dequeue();
        }
        if(filaPreferencial.checkFirst() != null && filaComum.checkFirst() ==null){
            return filaPreferencial.dequeue();
        }
        if (filaComum.checkFirst() != null && filaPreferencial.checkFirst() != null) {
            tokenComum = filaComum.checkFirst();
            tokenPreferencial = filaPreferencial.checkFirst();
            return getComumOuPreferencial(tokenComum, tokenPreferencial);
        }
        return filaComum.dequeue();
    }

    private Token getComumOuPreferencial(Token tokenComum, Token tokenPreferencial) {
        if (tokenComum.getDataEntrada().isBefore(tokenPreferencial.getDataEntrada())) {
            if (tokenComum.getDataEntrada().until(tokenPreferencial.getDataEntrada(), ChronoUnit.MINUTES) > 40) {
                return filaComum.dequeue();
            }
        }
        return filaPreferencial.dequeue();
    }
}

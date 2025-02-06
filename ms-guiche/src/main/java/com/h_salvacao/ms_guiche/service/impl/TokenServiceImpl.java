package com.h_salvacao.ms_guiche.service.impl;

import com.h_salvacao.ms_guiche.feignCliente.TokenFeingClient;
import com.h_salvacao.ms_guiche.model.*;
import com.h_salvacao.ms_guiche.service.TokenProducerSender;
import com.h_salvacao.ms_guiche.service.TokenService;
import com.h_salvacao.ms_guiche.service.TempoAtendimentoService;
import com.h_salvacao.ms_guiche.util.AtendimentoStatus;
import com.h_salvacao.ms_guiche.util.Queue;
import com.h_salvacao.ms_guiche.util.TipoAtendimento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Log4j2
@RequiredArgsConstructor
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    Queue<Token> lista;

    @Autowired
    TempoAtendimentoService atendimentoService;

    private final TokenProducerSender producerSender;



    private final TokenFeingClient tokenFeingClient;

    @Override
    public void adicionarFila(Token token) {
        lista.enqueue(token);


    }

    @Override
    public Integer pegarTotal(){
        return  lista.size();
    }

    @Override
    public Token chamarProximo() {
        try {
            String numToken = lista.dequeue().getNumToken();
            Token token = tokenFeingClient.getToken(numToken).getBody();
            if (token != null && token.getStatus() == AtendimentoStatus.GUICHE){
                producerSender.sendoToAtendimento(token);
                TempoAtendimento tempoAtendimento = atendimentoService.getTempoAtendimento(numToken);
                atendimentoService.atualizarEntradaAtendimento(tempoAtendimento);
                return token;
            }
        }catch (Exception e){
            log.info(e.getMessage());
        }

            return new Token(0L,"0", LocalDateTime.now(), null, AtendimentoStatus.DESCONHECIDO, TipoAtendimento.DESCONHECIDO, false);
    }


    @Override
    public Token encaminharToken(Token token) {
        token = setStatus(token,AtendimentoStatus.DOUTOR);
        Token tokenLocal = updateToken(token);
        TempoAtendimento atendimento = atendimentoService.getTempoAtendimento(tokenLocal.getNumToken());
        atendimentoService.atualizarSaidaAtendimento(atendimento);
        producerSender.send(tokenLocal);
        return  tokenLocal;
    }
@Override
    public Token updateToken(Token token) {
        return  tokenFeingClient.updateToken(token);
    }

    @Override
    public Token setStatus(Token token, AtendimentoStatus atendimentoStatus) {
        token.setStatus(atendimentoStatus);
        return token;
    }
}

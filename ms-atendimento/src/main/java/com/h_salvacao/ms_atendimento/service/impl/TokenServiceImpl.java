package com.h_salvacao.ms_atendimento.service.impl;

import com.h_salvacao.ms_atendimento.util.Stack;
import com.h_salvacao.ms_atendimento.model.Token;
import com.h_salvacao.ms_atendimento.service.TokenService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Log4j2
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    Stack<Token> pilha;
    @Override
    public Token adicionarPilha(Token value) {
        log.info("Recebido token: "+ value.getNumToken());
        pilha.push(value);
        return value;
    }

    @Override
    public Integer getTamanho() {
        return pilha.lenth();
    }

    @Override
    public Stack<Token> getStack() {
        return pilha;
    }


}

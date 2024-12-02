package com.h_salvacao.ms_atendimento.service.impl;

import com.h_salvacao.ms_atendimento.model.Atendimento;
import com.h_salvacao.ms_atendimento.model.Stack;
import com.h_salvacao.ms_atendimento.model.Token;
import com.h_salvacao.ms_atendimento.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtendimentoServiceImpl implements AtendimentoService {
    @Autowired
    Atendimento atendimento;
    @Override
    public Token adicionarPilha(Token value) {
        System.out.println("Recebido token: "+ value.getNumToken());
        atendimento.adicionarPilha(value);
        return value;
    }

    @Override
    public Integer getTamanho() {
        return atendimento.getSize();
    }

    @Override
    public Stack<Token> getStack() {
        return atendimento.getStack();

    }


}

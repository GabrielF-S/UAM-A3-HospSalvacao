package com.h_salvacao.ms_atendimento.service;

import com.h_salvacao.ms_atendimento.util.Stack;
import com.h_salvacao.ms_atendimento.model.Token;

public interface TokenService {
    Token adicionarPilha(Token value);

    Integer getTamanho();

    Stack<Token> getStack();
}

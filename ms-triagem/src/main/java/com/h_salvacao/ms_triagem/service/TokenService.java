package com.h_salvacao.ms_triagem.service;

import com.h_salvacao.ms_triagem.util.AtendimentoStatus;
import com.h_salvacao.ms_triagem.util.Queue;
import com.h_salvacao.ms_triagem.model.Token;

public interface TokenService {

    void adcionarFila(Token token);

    Integer pegarTotal();

    Token chamarProximo();

    void sendToken(Token token);

    Token setStatus(Token token, AtendimentoStatus atendimentoStatus);

    void updateToken(Token token);
}


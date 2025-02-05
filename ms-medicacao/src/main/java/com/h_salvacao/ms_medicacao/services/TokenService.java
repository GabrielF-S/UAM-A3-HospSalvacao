package com.h_salvacao.ms_medicacao.services;

import com.h_salvacao.ms_medicacao.util.AtendimentoStatus;
import com.h_salvacao.ms_medicacao.model.Token;

public interface TokenService {

    void updateToken(Token token);

    Token getToken(String numToken);

    Token setRetorno(Token token);

    Token setStatus(Token token ,AtendimentoStatus atendimentoStatus);
}

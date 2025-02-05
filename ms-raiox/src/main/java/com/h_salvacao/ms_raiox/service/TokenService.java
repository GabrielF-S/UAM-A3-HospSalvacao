package com.h_salvacao.ms_raiox.service;

import com.h_salvacao.ms_raiox.model.Token;
import com.h_salvacao.ms_raiox.util.AtendimentoStatus;

public interface TokenService {
    Token getToken(String numToken);

    Token setStatus(Token token, AtendimentoStatus atendimentoStatus);

    Token setRetorno(Token token);

    void updateToken(Token token);
}

package com.h_salvacao.ms_medico.service;

import com.h_salvacao.ms_medico.model.*;
import com.h_salvacao.ms_medico.util.AtendimentoStatus;


public interface TokenService {
    void adicionarFila(Token value);

    Integer getTotal();

    Token chamarProximo();

    void adicionarFilaRetornoDoRaioX(Token value);

    Token encerrarAtendimento(Token token);

    Token setStatus(Token token, AtendimentoStatus atendimentoStatus);

    Token getToken(String numToken);

    void updateToken(Token token);
}


package com.h_salvacao.ms_guiche.service;

import com.h_salvacao.ms_guiche.model.Paciente;
import com.h_salvacao.ms_guiche.model.Token;
import com.h_salvacao.ms_guiche.util.AtendimentoStatus;

public interface TokenService {

    void adicionarFila(Token token);

    Integer pegarTotal();

    Token chamarProximo();

    Token encaminharToken(Token token);

    Token updateToken(Token token);

    Token setStatus(Token token, AtendimentoStatus atendimentoStatus);
}

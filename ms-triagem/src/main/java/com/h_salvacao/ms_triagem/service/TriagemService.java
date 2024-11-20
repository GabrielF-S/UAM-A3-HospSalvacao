package com.h_salvacao.ms_triagem.service;

import com.h_salvacao.ms_triagem.model.Token;

import java.util.List;

public interface TriagemService {

    void adcionarFila(Token token);

    List<Token> exibirFila();

    Integer pegarTotal();

    Token chamarProximo();
}

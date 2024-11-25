package com.h_salvacao.ms_triagem.service;

import com.h_salvacao.ms_triagem.model.Queue;
import com.h_salvacao.ms_triagem.model.Token;

import java.util.List;

public interface TriagemService {

    void adcionarFila(Token token);

    Queue<Token> exibirFila();

    Integer pegarTotal();

    Token chamarProximo();
}

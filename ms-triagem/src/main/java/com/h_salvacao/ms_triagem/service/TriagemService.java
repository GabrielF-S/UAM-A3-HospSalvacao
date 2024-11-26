package com.h_salvacao.ms_triagem.service;

import com.h_salvacao.ms_triagem.model.Ficha;
import com.h_salvacao.ms_triagem.model.Queue;
import com.h_salvacao.ms_triagem.model.Token;

public interface TriagemService {

    void adcionarFila(Token token);

    Queue<Token> exibirFila();

    Integer pegarTotal();

    Token chamarProximo();

    Ficha enviarFicha(Ficha ficha);

    void atualizarToken(Ficha ficha);
}

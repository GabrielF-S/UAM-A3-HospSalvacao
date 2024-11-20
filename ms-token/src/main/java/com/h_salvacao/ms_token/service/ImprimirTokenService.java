package com.h_salvacao.ms_token.service;

import com.h_salvacao.ms_token.model.Token;


public interface ImprimirTokenService {

    void Imprimir(Token token);

    void criarArquivo(Token token);

    void imprimirArquivo();

    void excluirArquivo();
}

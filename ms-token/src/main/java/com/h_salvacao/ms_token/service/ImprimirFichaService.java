package com.h_salvacao.ms_token.service;

import com.h_salvacao.ms_token.entity.Token;


public interface ImprimirFichaService {

    void Imprimir(Token token);

    void criarArquivo(Token token);

    void imprimirArquivo();

    void excluirArquivo();
}

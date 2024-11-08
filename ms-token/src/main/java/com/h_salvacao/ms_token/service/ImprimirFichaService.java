package com.h_salvacao.ms_token.service;

import com.h_salvacao.ms_token.entity.Ficha;
import org.springframework.stereotype.Service;


public interface ImprimirFichaService {

    void Imprimir(Ficha ficha) throws InterruptedException;

    void criarArquivo(Ficha ficha);

    void imprimirArquivo();

    void excluirArquivo();
}

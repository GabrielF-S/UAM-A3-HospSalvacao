package com.h_salvacao.ms_medico.service;

import com.h_salvacao.ms_medico.model.Receita;

public interface ImprimirReceitaService {
    void imprimir(Receita receita);

    String criarArquivo(Receita receita);
    void imprimirArquivo(String nomeArquivo);

    void excluirArquivo(String nomeArquivo);
}

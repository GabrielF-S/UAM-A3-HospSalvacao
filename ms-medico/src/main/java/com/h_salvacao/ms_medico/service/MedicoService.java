package com.h_salvacao.ms_medico.service;

import com.h_salvacao.ms_medico.model.*;


public interface MedicoService {
    void adicionarFila(Token value);

    Integer getTotal();

    Token chamarProximo();

    Ficha getFicha(Long tokenId);

    Ficha atualizarFicha(Ficha ficha);

    Receita salvarReceita(Receita receita);

    void imprimirReceita(Receita receita);

    Encaminhamento encaminharPaciente(Encaminhamento encaminhamento);

    void adicionarFilaRetornoDoRaioX(Token value);

    Token encerrarAtendimento(Token token);

    Encaminhamento getEncaminhamento(String numToken);
}


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


//    private final TriagemFeignClient triagemFeignClient;
//
//    public MedicoService(TriagemFeignClient triagemFeignClient) {
//        this.triagemFeignClient = triagemFeignClient;
//    }
//
//    public Token chamarMedico() {
//        Token primeiroElemento = triagemFeignClient.chamarMedico();
//
//        if (primeiroElemento == null) {
//            System.out.println("A fila está vazia.");
//        }
//
//        return primeiroElemento;
//    }
}


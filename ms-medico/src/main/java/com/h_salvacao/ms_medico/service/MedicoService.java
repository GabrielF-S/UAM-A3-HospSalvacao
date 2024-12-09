package com.h_salvacao.ms_medico.service;

import com.h_salvacao.ms_medico.model.Ficha;
import com.h_salvacao.ms_medico.model.Medicacao;
import com.h_salvacao.ms_medico.model.Queue;
import com.h_salvacao.ms_medico.model.Token;


public interface MedicoService {
    void adicionarFila(Token value);

    Integer getTotal();

    Token chamarProximo();

    Ficha getFicha(Long tokenId);

    Ficha atualizarFicha(Ficha ficha);

    Queue<Medicacao> adicionarMedicacao(Medicacao medicacao);

    Queue<Medicacao> abrirReceita(Medicacao medicacao);


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


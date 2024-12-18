package com.h_salvacao.ms_medico.controller;

import com.h_salvacao.ms_medico.model.Ficha;
import com.h_salvacao.ms_medico.model.Medicacao;
import com.h_salvacao.ms_medico.model.Receita;
import com.h_salvacao.ms_medico.model.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface MedicoController {

    @GetMapping(value = "getQtd")
    ResponseEntity<Integer> getQuantidadeTotalFila();

    @GetMapping(value = "getProximo")
    ResponseEntity<Token> getProximo();

    @GetMapping(value = "getFicha/{tokenId}")
    ResponseEntity<Ficha> getFicha(@PathVariable("tokenId") Long tokenId);

    @PostMapping(value = "atualizarFica")
    ResponseEntity<Ficha> atualizarFicha(Ficha ficha);

    @PostMapping(value = "salvarReceita")
    ResponseEntity<?> salvarReceita(Receita receita);

    @PostMapping(value = "imprimirReceita")
    void imprimirReceita(Receita receita);


}

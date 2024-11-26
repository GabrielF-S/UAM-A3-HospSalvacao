package com.h_salvacao.ms_triagem.controller;

import com.h_salvacao.ms_triagem.model.Ficha;
import com.h_salvacao.ms_triagem.model.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface TriagemController {

    @GetMapping(value = "getQtd")
    ResponseEntity<Integer> getQuantidadeTotalFila();

    @GetMapping(value = "getProximo")
    ResponseEntity<Token> getProximo();

    @PostMapping(value = "save")
    ResponseEntity<Ficha> abrirFicha(Ficha ficha);


}

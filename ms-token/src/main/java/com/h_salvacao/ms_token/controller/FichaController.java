package com.h_salvacao.ms_token.controller;

import com.h_salvacao.ms_token.entity.Ficha;
import com.h_salvacao.ms_token.entity.FichaAtendimento;
import com.h_salvacao.ms_token.entity.TipoAtendimento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface FichaController {
    @GetMapping(value = "/gerarFicha")
    ResponseEntity<Ficha> gerarFicha(FichaAtendimento atendimento) throws InterruptedException;

    @PostMapping(value = "/gerarFicha")
    ResponseEntity<Ficha> salvarFicha(Ficha ficha);



}

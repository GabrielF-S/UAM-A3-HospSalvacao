package com.h_salvacao.ms_medico.controller;

import com.h_salvacao.ms_medico.model.Ficha;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface FichaController {

    @GetMapping(value = "getFicha/{tokenId}")
    ResponseEntity<Ficha> getFicha(@PathVariable("tokenId") Long tokenId);

    @PostMapping(value = "atualizarFicha")
    ResponseEntity<Ficha> atualizarFicha(Ficha ficha);

}

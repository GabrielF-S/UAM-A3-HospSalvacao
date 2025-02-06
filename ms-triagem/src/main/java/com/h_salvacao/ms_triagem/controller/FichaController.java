package com.h_salvacao.ms_triagem.controller;

import com.h_salvacao.ms_triagem.model.Ficha;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;

public interface FichaController {
    @PutMapping(value = "save")
    ResponseEntity<Ficha> abrirFichaEncaminharPaciente(Ficha ficha);
}

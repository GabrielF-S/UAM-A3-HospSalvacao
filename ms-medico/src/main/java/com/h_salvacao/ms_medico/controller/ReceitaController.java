package com.h_salvacao.ms_medico.controller;

import com.h_salvacao.ms_medico.model.Receita;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface ReceitaController {

    @PostMapping(value = "salvarReceita")
    ResponseEntity<?> salvarReceita(Receita receita);

    @PostMapping(value = "imprimirReceita")
    void imprimirReceita(Receita receita);
}

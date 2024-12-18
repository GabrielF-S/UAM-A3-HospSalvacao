package com.h_salvacao.ms_connect.controller;

import com.h_salvacao.ms_connect.entity.Receita;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ReceitaController {
    @PostMapping(value = "salvar")
    ResponseEntity<?> salvarReceita(@RequestBody  Receita receita);
}

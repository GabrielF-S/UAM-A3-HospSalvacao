package com.h_salvacao.ms_guiche.controller;

import com.h_salvacao.ms_guiche.model.Paciente;
import com.h_salvacao.ms_guiche.model.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public interface TokenController {
    @GetMapping(value = "getQtd")
    ResponseEntity<Integer> getQuantidadeTotalFila();

    @GetMapping(value = "getProximo")
    ResponseEntity<Token> getProximo();

    @PostMapping(value = "encaminharToken")
    ResponseEntity<Token> encaminahrToken(Token token);


}

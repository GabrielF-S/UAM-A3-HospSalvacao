package com.h_salvacao.ms_medico.controller;

import com.h_salvacao.ms_medico.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface TokenController {

    @GetMapping(value = "getQtd")
    ResponseEntity<Integer> getQuantidadeTotalFila();

    @GetMapping(value = "getProximo")
    ResponseEntity<Token> getProximo();

    @PostMapping(value = "encerrarAtendimento")
    ResponseEntity<Token> encerrarAtendimento(Token token);



}

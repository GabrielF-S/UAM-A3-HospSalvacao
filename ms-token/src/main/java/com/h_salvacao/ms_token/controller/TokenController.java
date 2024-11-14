package com.h_salvacao.ms_token.controller;

import com.h_salvacao.ms_token.entity.Token;
import com.h_salvacao.ms_token.entity.TokenAtendimento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface TokenController {
    @PostMapping(value = "/gerarFicha")
    ResponseEntity<Token> gerarFicha(TokenAtendimento atendimento) throws InterruptedException;

    @PostMapping(value = "/atualizarFicha")
    ResponseEntity<Token> salvarFicha(Token ficha);



}

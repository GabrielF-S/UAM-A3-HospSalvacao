package com.h_salvacao.ms_token.controller;

import com.h_salvacao.ms_token.model.Token;
import com.h_salvacao.ms_token.util.TokenAtendimento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface TokenController {
    @PostMapping(value = "/gerarFicha")
    ResponseEntity<Token> gerarToken(TokenAtendimento atendimento) throws InterruptedException;

    @PostMapping(value = "/atualizarFicha")
    ResponseEntity<Token> salvarToken(Token ficha);



}

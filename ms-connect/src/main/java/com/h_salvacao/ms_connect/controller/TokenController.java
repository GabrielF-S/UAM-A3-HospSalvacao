package com.h_salvacao.ms_connect.controller;

import com.h_salvacao.ms_connect.entity.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface TokenController {

    @PostMapping(value = "save")
    ResponseEntity<Token> salvarToken(Token token);

    @GetMapping(value = "getId/{id}")
    ResponseEntity<Token> getTokenById(Long id);

    @GetMapping(value = "getToken/{numToken}")
    ResponseEntity<Token> getToken(String numToken);

    @GetMapping(value ="get")
    ResponseEntity<List<Token>> getAllTokens();



}
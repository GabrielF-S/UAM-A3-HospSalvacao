package com.h_salvacao.ms_connect.service;

import com.h_salvacao.ms_connect.entity.Token;

import java.util.List;

public interface TokenService {


    Token salvarToken(Token token);

    Token getToken(Long id);

    Token getByToken(String numToken);

    List<Token> getAll();
}

package com.h_salvacao.ms_connect.service;

import com.h_salvacao.ms_connect.entity.MyList;
import com.h_salvacao.ms_connect.entity.Token;

public interface TokenService {


    Token salvarToken(Token token);

    Token getToken(Long id);

    Token getByToken(String numToken);

    MyList getAll();

    Token atualizarToken(Token token);
}

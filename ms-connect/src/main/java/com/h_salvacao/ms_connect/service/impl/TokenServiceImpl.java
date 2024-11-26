package com.h_salvacao.ms_connect.service.impl;

import com.h_salvacao.ms_connect.entity.Token;
import com.h_salvacao.ms_connect.repository.TokenRepository;
import com.h_salvacao.ms_connect.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    TokenRepository repository;


    @Override
    public Token salvarToken(Token token) {
       return  repository.save(token);
    }

    @Override
    public Token getToken(Long id) {
        return  repository.findById(id).get();
    }

    @Override
    public Token getByToken(String numToken) {
        return  repository.findBynumToken(numToken).get();
    }

    @Override
    public List<Token> getAll() {
        return repository.findAll();
    }

    @Override
    public Token atualizarToken(Token token) {
        return repository.save(token);
    }
}

package com.h_salvacao.ms_connect.service.impl;

import com.h_salvacao.ms_connect.util.MyList;
import com.h_salvacao.ms_connect.entity.TempoAtendimento;
import com.h_salvacao.ms_connect.entity.Token;
import com.h_salvacao.ms_connect.exceptions.NumTokenException;
import com.h_salvacao.ms_connect.exceptions.TokenException;
import com.h_salvacao.ms_connect.repository.TokenRepository;
import com.h_salvacao.ms_connect.service.TempoAtenidmentoService;
import com.h_salvacao.ms_connect.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    TokenRepository repository;

    @Autowired
    TempoAtenidmentoService tempoAtenidmentoService;

    @Autowired
    MyList myList;


    @Override
    public Token salvarToken(Token token) {
        if (token != null) {
            repository.save(token);
            TempoAtendimento atendimento = tempoAtenidmentoService.CriarTempoAtendimento(token);
            tempoAtenidmentoService.salvarTempo(atendimento);
            return token;
        }
        throw new TokenException();
    }

    @Override
    public Token getToken(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Token getByToken(String numToken) {
        if (numToken.isEmpty()){
            throw new NumTokenException();
        }
        return repository.findBynumToken(numToken).get();
    }

    @Override
    public MyList getAll() {
        for (Token t : repository.findAll()) {
            myList.inserirFim(t);
        }

        return myList;
    }

    @Override
    public Token atualizarToken(Token token) {
        if (token != null) {

            return repository.save(token);
        } else {
            throw new TokenException();
        }
    }
}

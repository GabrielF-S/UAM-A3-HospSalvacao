package com.h_salvacao.ms_triagem.service.impl;

import com.h_salvacao.ms_triagem.entity.Token;
import com.h_salvacao.ms_triagem.entity.Triagem;
import com.h_salvacao.ms_triagem.service.TriagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TriagemServiceImpl implements TriagemService {
    @Autowired
    Triagem triagem;

    @Override
    public void adcionarFila(Token token) {

        triagem.adicionarToken(token);
        System.out.println(triagem.getTokenList());

    }
}

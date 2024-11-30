package com.h_salvacao.ms_atendimento.service.impl;

import com.h_salvacao.ms_atendimento.model.Atendimento;
import com.h_salvacao.ms_atendimento.model.Token;
import com.h_salvacao.ms_atendimento.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtendimentoServiceImpl implements AtendimentoService {
    @Autowired
    Atendimento atendimento;
    @Override
    public void adicionarPilha(Token value) {
        atendimento.adicionarPilha(value);
    }

    @Override
    public Integer getTamanho() {
        return atendimento.getSize();
    }


}

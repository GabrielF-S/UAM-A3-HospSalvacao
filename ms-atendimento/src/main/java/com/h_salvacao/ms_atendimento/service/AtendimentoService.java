package com.h_salvacao.ms_atendimento.service;

import com.h_salvacao.ms_atendimento.model.Token;

public interface AtendimentoService {
    void adicionarPilha(Token value);

    Integer getTamanho();
}

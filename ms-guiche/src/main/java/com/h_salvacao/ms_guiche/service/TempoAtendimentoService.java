package com.h_salvacao.ms_guiche.service;

import com.h_salvacao.ms_guiche.model.TempoAtendimento;

public interface TempoAtendimentoService {
    void atualizarEntradaAtendimento(TempoAtendimento atendimento);

    void atualizarSaidaAtendimento(TempoAtendimento atendimento);


    TempoAtendimento getTempoAtendimento(String numToken);
}

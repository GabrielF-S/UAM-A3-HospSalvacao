package com.h_salvacao.ms_medicacao.services;

import com.h_salvacao.ms_medicacao.model.TempoAtendimento;

public interface AtendimentoService {

    void atualizarEntradaAtendimento(String numToken);

    void atualizarSaidaAtendimento(TempoAtendimento atendimento);

    TempoAtendimento getTempoAtendimento(String numToken);
}

package com.h_salvacao.ms_raiox.service;


import com.h_salvacao.ms_raiox.model.TempoAtendimento;

public interface TempoAtendimentoService {
    void atualizarEntradaAtendimento(String numToken);

    void atualizarSaidaAtendimento(TempoAtendimento atendimento);

    TempoAtendimento getTempoAtendimento(String numToken);


}

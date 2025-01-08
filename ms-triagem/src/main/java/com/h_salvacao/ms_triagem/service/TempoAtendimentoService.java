package com.h_salvacao.ms_triagem.service;

import com.h_salvacao.ms_triagem.model.TempoAtendimento;

public interface TempoAtendimentoService {
    void atualizarEntradaAtendimento(TempoAtendimento atendimento);

    void atualizarSaidaAtendimento(TempoAtendimento atendimento);
}

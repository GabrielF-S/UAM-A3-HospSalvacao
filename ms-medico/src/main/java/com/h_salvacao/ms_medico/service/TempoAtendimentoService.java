package com.h_salvacao.ms_medico.service;

import com.h_salvacao.ms_medico.model.TempoAtendimento;

public interface TempoAtendimentoService {
    void atualizarEntradaAtendimento(TempoAtendimento atendimento);

    void atualizarSaidaAtendimento(TempoAtendimento atendimento);
}

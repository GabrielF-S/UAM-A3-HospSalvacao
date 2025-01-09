package com.h_salvacao.ms_medico.service;

import com.h_salvacao.ms_medico.model.TempoAtendimento;

public interface TempoAtendimentoService {
    void atualizarEntradaMedico(TempoAtendimento atendimento);

    void atualizarSaidaMedico(TempoAtendimento atendimento);

    void atualizarEntradaRetorno(TempoAtendimento atendimento);

    void atualizarSaidaRetorno(TempoAtendimento atendimento);
}

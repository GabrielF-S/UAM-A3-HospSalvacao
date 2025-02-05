package com.h_salvacao.ms_medico.service;

import com.h_salvacao.ms_medico.model.TempoAtendimento;
import com.h_salvacao.ms_medico.model.Token;

import java.time.LocalTime;

public interface TempoAtendimentoService {
    void atualizarEntradaMedico(TempoAtendimento atendimento);

    void atualizarSaidaMedico(TempoAtendimento atendimento);

    void atualizarEntradaRetorno(TempoAtendimento atendimento);

    void atualizarSaidaRetorno(TempoAtendimento atendimento);

    void encerrarAtendimento(TempoAtendimento atendimento);

    TempoAtendimento getTempoAtendimento(String numToken);

    LocalTime getRetorno(String numToken);
}

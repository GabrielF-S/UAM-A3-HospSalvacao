package com.h_salvacao.ms_connect.service;

import com.h_salvacao.ms_connect.entity.TempoAtendimento;
import com.h_salvacao.ms_connect.entity.Token;

import java.time.LocalDate;
import java.util.List;

public interface TempoAtenidmentoService {

    TempoAtendimento CriarTempoAtendimento(Token token);

    void salvarTempo(TempoAtendimento atendimento);

    TempoAtendimento getByNumToken(String numToken);

    TempoAtendimento updateAtendimento(TempoAtendimento atendimento);

    List<TempoAtendimento> getAllAtendimentosDoDia();

    List<TempoAtendimento> getAtendimentoPorPeriodo(LocalDate dataInicio, LocalDate dataFinal);
}

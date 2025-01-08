package com.h_salvacao.ms_connect.service;

import com.h_salvacao.ms_connect.entity.TempoAtendimento;
import com.h_salvacao.ms_connect.entity.Token;

public interface TempoAtenidmentoService {

    TempoAtendimento CriarTempoAtendimento(Token token);

    void salvarTempo(TempoAtendimento atendimento);

    TempoAtendimento getByNumToken(String numToken);

    TempoAtendimento updateAtendimento(TempoAtendimento atendimento);
}

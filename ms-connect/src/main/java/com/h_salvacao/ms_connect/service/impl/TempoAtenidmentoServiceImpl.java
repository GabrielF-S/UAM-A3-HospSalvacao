package com.h_salvacao.ms_connect.service.impl;

import com.h_salvacao.ms_connect.entity.TempoAtendimento;
import com.h_salvacao.ms_connect.entity.Token;
import com.h_salvacao.ms_connect.repository.TempoAtendimentoRepository;
import com.h_salvacao.ms_connect.service.TempoAtenidmentoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
@AllArgsConstructor
@Service
public class TempoAtenidmentoServiceImpl implements TempoAtenidmentoService {
    private TempoAtendimentoRepository tempoAtendimentoRepository;


    @Override
    public TempoAtendimento CriarTempoAtendimento(Token token) {
        LocalTime time = token.getDataEntrada().toLocalTime();

       return TempoAtendimento.builder().numToken(token.getNumToken()).dataEntrada(token.getDataEntrada()).horarioEntrada(token.getDataEntrada().toLocalTime()).build();


    }

    @Override
    public void salvarTempo(TempoAtendimento atendimento) {
        tempoAtendimentoRepository.save(atendimento);
    }
}

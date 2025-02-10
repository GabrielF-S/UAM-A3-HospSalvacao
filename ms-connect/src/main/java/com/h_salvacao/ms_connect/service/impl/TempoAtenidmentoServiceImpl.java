package com.h_salvacao.ms_connect.service.impl;

import com.h_salvacao.ms_connect.entity.TempoAtendimento;
import com.h_salvacao.ms_connect.entity.Token;
import com.h_salvacao.ms_connect.exceptions.TempoAtendimentoException;
import com.h_salvacao.ms_connect.repository.TempoAtendimentoRepository;
import com.h_salvacao.ms_connect.service.TempoAtenidmentoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@Service
public class TempoAtenidmentoServiceImpl implements TempoAtenidmentoService {
    private TempoAtendimentoRepository tempoAtendimentoRepository;


    @Override
    public TempoAtendimento CriarTempoAtendimento(Token token) {
        if (token != null) {
            return TempoAtendimento.builder().numToken(token.getNumToken()).dataEntrada(token.getDataEntrada()).horarioEntrada(token.getDataEntrada().toLocalTime()).diaEntrada(LocalDate.now()).build();
        }else {
            throw new TempoAtendimentoException();
        }


    }

    @Override
    public void salvarTempo(TempoAtendimento atendimento) {
        if (atendimento != null) {
            tempoAtendimentoRepository.save(atendimento);
        }else {
            throw new TempoAtendimentoException();
        }

    }

    @Override
    public TempoAtendimento getByNumToken(String numToken) {
        return tempoAtendimentoRepository.findBynumToken(numToken).get();
    }

    @Override
    public TempoAtendimento updateAtendimento(TempoAtendimento atendimento) {
        if (atendimento != null) {
            return tempoAtendimentoRepository.save(atendimento);
        }else {
            throw new TempoAtendimentoException();
        }
    }

    @Override
    public List<TempoAtendimento> getAllAtendimentosDoDia() {
        return tempoAtendimentoRepository.getBydiaEntrada(LocalDate.now()).get();
    }

    @Override
    public List<TempoAtendimento> getAtendimentoPorPeriodo(LocalDate dataInicio, LocalDate dataFinal) {
        return tempoAtendimentoRepository.getAtendimentoPorPeriodo(dataInicio, dataFinal).get();
    }
}

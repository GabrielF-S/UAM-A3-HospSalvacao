package com.h_salvacao.ms_medicacao.services.impl;

import com.h_salvacao.ms_medicacao.feingClient.EncaminhamentoFeingClient;
import com.h_salvacao.ms_medicacao.feingClient.TempoAtendimentoFeigClient;
import com.h_salvacao.ms_medicacao.model.TempoAtendimento;
import com.h_salvacao.ms_medicacao.services.AtendimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
@Service
@RequiredArgsConstructor
public class AtendimentoServiceImpl implements AtendimentoService {
    private final TempoAtendimentoFeigClient atendimentoFeigClient;
    @Override
    public void atualizarEntradaAtendimento(String numToken) {
        TempoAtendimento tempoAtendimento = atendimentoFeigClient.getTempoAtendimento(numToken);
        tempoAtendimento.setEntradaMedicacao(LocalTime.now());
        atendimentoFeigClient.updateAtendimento(tempoAtendimento);
    }

    @Override
    public void atualizarSaidaAtendimento(TempoAtendimento tempoAtendimento) {
        tempoAtendimento.setSaidaMedicacao(LocalTime.now());
        atendimentoFeigClient.updateAtendimento(tempoAtendimento);

    }

    @Override
    public TempoAtendimento getTempoAtendimento(String numToken) {
        TempoAtendimento tempoAtendimento =atendimentoFeigClient.getTempoAtendimento(numToken);
        return tempoAtendimento;
    }
}

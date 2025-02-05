package com.h_salvacao.ms_raiox.service.impl;


import com.h_salvacao.ms_raiox.feingClient.TempoAtendimentoFeigClient;
import com.h_salvacao.ms_raiox.model.TempoAtendimento;
import com.h_salvacao.ms_raiox.service.TempoAtendimentoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@AllArgsConstructor
public class TempoAtendimentoServiceImpl implements TempoAtendimentoService {

    private final TempoAtendimentoFeigClient atendimentoFeigClient;

    @Override
    public void atualizarEntradaAtendimento(String numToken) {
        TempoAtendimento tempoAtendimento = atendimentoFeigClient.getTempoAtendimento(numToken);
        tempoAtendimento.setEntradaRaioX(LocalTime.now());

    }

    @Override
    public void atualizarSaidaAtendimento(TempoAtendimento atendimento) {
        atendimento.setSaidaRaioX(LocalTime.now());
        atendimentoFeigClient.updateAtendimento(atendimento);

    }

    @Override
    public TempoAtendimento getTempoAtendimento(String numToken) {
        TempoAtendimento tempoAtendimento = atendimentoFeigClient.getTempoAtendimento(numToken);
        return tempoAtendimento;
    }
}

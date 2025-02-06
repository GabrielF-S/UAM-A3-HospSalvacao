package com.h_salvacao.ms_triagem.service.impl;

import com.h_salvacao.ms_triagem.feignCliente.TempoAtendimentoFeignClient;
import com.h_salvacao.ms_triagem.model.TempoAtendimento;
import com.h_salvacao.ms_triagem.service.TempoAtendimentoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@AllArgsConstructor
public class TempoAtendimentoServiceImpl implements TempoAtendimentoService {
    private final TempoAtendimentoFeignClient tempoAtendimentoFeignClient;
    @Override
    public void atualizarEntradaAtendimento(TempoAtendimento atendimento) {
        atendimento.setEntradaTriagem(LocalTime.now());
        tempoAtendimentoFeignClient.updateAtendimento(atendimento);
    }
    @Override
    public void atualizarSaidaAtendimento(TempoAtendimento atendimento) {
        atendimento.setSaidaTriagem(LocalTime.now());
        tempoAtendimentoFeignClient.updateAtendimento(atendimento);
    }

    @Override
    public TempoAtendimento getTempoAtendimento(String numToken) {
        return tempoAtendimentoFeignClient.getTempoAtendimento(numToken);
    }
}

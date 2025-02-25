package com.h_salvacao.ms_guiche.service.impl;

import com.h_salvacao.ms_guiche.feignCliente.TempoAtendimentoFeignClient;
import com.h_salvacao.ms_guiche.model.TempoAtendimento;
import com.h_salvacao.ms_guiche.service.TempoAtendimentoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@AllArgsConstructor
public class TempoAtendimentoServiceImpl implements TempoAtendimentoService {
    private final TempoAtendimentoFeignClient feignClient;
    @Override
    public void atualizarEntradaAtendimento(TempoAtendimento atendimento) {
        atendimento.setEntradaGuiche(LocalTime.now());
        feignClient.updateAtendimento(atendimento);
    }
    @Override
    public void atualizarSaidaAtendimento(TempoAtendimento atendimento) {
        atendimento.setSaidaGuiche(LocalTime.now());
        feignClient.updateAtendimento(atendimento);
    }

    @Override
    public TempoAtendimento getTempoAtendimento(String numToken) {
        return feignClient.getTempoAtendimento(numToken);
    }
}

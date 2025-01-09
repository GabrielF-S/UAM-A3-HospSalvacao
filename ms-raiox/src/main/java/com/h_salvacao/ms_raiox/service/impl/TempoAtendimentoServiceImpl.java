package com.h_salvacao.ms_raiox.service.impl;


import com.h_salvacao.ms_raiox.feingClient.RaioXFeingClient;
import com.h_salvacao.ms_raiox.model.TempoAtendimento;
import com.h_salvacao.ms_raiox.service.TempoAtendimentoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@AllArgsConstructor
public class TempoAtendimentoServiceImpl implements TempoAtendimentoService {
    private final RaioXFeingClient feignClient;

    @Override
    public void atualizarEntraRaioX(TempoAtendimento atendimento) {
        atendimento.setEntradaDoutor(LocalTime.now());
        feignClient.updateAtendimento(atendimento);
    }
    @Override
    public void atualizarSaidaRaioX(TempoAtendimento atendimento) {
        atendimento.setSaidaDoutor(LocalTime.now());
        feignClient.updateAtendimento(atendimento);
    }

}

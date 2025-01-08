package com.h_salvacao.ms_triagem.service.impl;

import com.h_salvacao.ms_triagem.feignCliente.TriagemFeignClient;
import com.h_salvacao.ms_triagem.model.TempoAtendimento;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@AllArgsConstructor
public class TempoAtendimentoService {
    private final TriagemFeignClient feignClient;

    public void atualizarEntradaAtendimento(TempoAtendimento atendimento) {
        atendimento.setEntradaTriagem(LocalTime.now());
        feignClient.updateAtendimento(atendimento);
    }

    public void atualizarSaidaAtendimento(TempoAtendimento atendimento) {
        atendimento.setSaidaTriagem(LocalTime.now());
        feignClient.updateAtendimento(atendimento);
    }
}

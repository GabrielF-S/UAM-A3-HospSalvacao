package com.h_salvacao.ms_medico.service.impl;

import com.h_salvacao.ms_medico.feignCliente.MedicoFeignClient;
import com.h_salvacao.ms_medico.model.TempoAtendimento;
import com.h_salvacao.ms_medico.service.TempoAtendimentoService;
import com.h_salvacao.ms_triagem.feignCliente.TriagemFeignClient;
import com.h_salvacao.ms_triagem.model.TempoAtendimento;
import com.h_salvacao.ms_triagem.service.TempoAtendimentoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@AllArgsConstructor
public class TempoAtendimentoServiceImpl implements TempoAtendimentoService {
    private final MedicoFeignClient feignClient;
    @Override
    public void atualizarEntradaAtendimento(TempoAtendimento atendimento) {
        atendimento.setEntradaDoutor(LocalTime.now());
        feignClient.updateAtendimento(atendimento);
    }
    @Override
    public void atualizarSaidaAtendimento(TempoAtendimento atendimento) {
        atendimento.setSaidaDoutor(LocalTime.now());
        feignClient.updateAtendimento(atendimento);
    }

    @Override
    public void atualizarEntradaAtendimento(TempoAtendimento atendimento) {
        atendimento.setEntradaRetornoDoutor(LocalTime.now());
        feignClient.updateAtendimento(atendimento);
    }
    @Override
    public void atualizarSaidaAtendimento(TempoAtendimento atendimento) {
        atendimento.setSaidaSaidaDoutor(LocalTime.now());
        feignClient.updateAtendimento(atendimento);
    }
}

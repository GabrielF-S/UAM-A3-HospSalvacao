package com.h_salvacao.ms_medico.service.impl;

import com.h_salvacao.ms_medico.feignCliente.MedicoFeignClient;
import com.h_salvacao.ms_medico.model.TempoAtendimento;
import com.h_salvacao.ms_medico.service.TempoAtendimentoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@AllArgsConstructor
public class TempoAtendimentoServiceImpl implements TempoAtendimentoService {
    private final MedicoFeignClient feignClient;

    @Override
    public void atualizarEntradaMedico(TempoAtendimento atendimento) {
        atendimento.setEntradaDoutor(LocalTime.now());
        feignClient.updateAtendimento(atendimento);
    }
    @Override
    public void atualizarSaidaMedico(TempoAtendimento atendimento) {
        atendimento.setSaidaDoutor(LocalTime.now());
        feignClient.updateAtendimento(atendimento);
    }

    @Override
    public void atualizarEntradaRetorno(TempoAtendimento atendimento) {
        atendimento.setEntradaRetornoDoutor(LocalTime.now());
        feignClient.updateAtendimento(atendimento);
    }
    @Override
    public void atualizarSaidaRetorno(TempoAtendimento atendimento) {
        atendimento.setSaidaSaidaDoutor(LocalTime.now());
        feignClient.updateAtendimento(atendimento);
    }
}

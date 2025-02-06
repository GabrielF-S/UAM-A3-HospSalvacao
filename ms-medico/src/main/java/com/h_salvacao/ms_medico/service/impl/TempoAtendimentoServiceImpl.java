package com.h_salvacao.ms_medico.service.impl;

import com.h_salvacao.ms_medico.feignCliente.TempoAtendimentoFeigClient;
import com.h_salvacao.ms_medico.model.TempoAtendimento;
import com.h_salvacao.ms_medico.service.TempoAtendimentoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@AllArgsConstructor
public class TempoAtendimentoServiceImpl implements TempoAtendimentoService {
    private final TempoAtendimentoFeigClient atendimentoFeigClient;

    @Override
    public void atualizarEntradaMedico(TempoAtendimento atendimento) {
        atendimento.setEntradaDoutor(LocalTime.now());
        atendimentoFeigClient.updateAtendimento(atendimento);
    }
    @Override
    public void atualizarSaidaMedico(TempoAtendimento atendimento) {
        atendimento.setSaidaDoutor(LocalTime.now());
        atendimentoFeigClient.updateAtendimento(atendimento);
    }

    @Override
    public void atualizarEntradaRetorno(TempoAtendimento atendimento) {
        atendimento.setEntradaRetornoDoutor(LocalTime.now());
        atendimentoFeigClient.updateAtendimento(atendimento);
    }
    @Override
    public void atualizarSaidaRetorno(TempoAtendimento atendimento) {
        atendimento.setSaidaRetornoDoutor(LocalTime.now());
        atendimentoFeigClient.updateAtendimento(atendimento);
    }

    @Override
    public void encerrarAtendimento(TempoAtendimento atendimento) {
        if(atendimento.getEntradaRetornoDoutor() !=null){
            atendimento.setSaidaRetornoDoutor(LocalTime.now());
        }
        atendimento.setHorarioSaida(LocalTime.now());
        atendimentoFeigClient.updateAtendimento(atendimento);
    }

    @Override
    public TempoAtendimento getTempoAtendimento(String numToken) {
        TempoAtendimento tempoAtendimento= atendimentoFeigClient.getTempoAtendimento(numToken);
        return tempoAtendimento;
    }

    @Override
    public LocalTime getRetorno(String numToken) {
        TempoAtendimento tempoAtendimento=  atendimentoFeigClient.getTempoAtendimento(numToken);
        if (tempoAtendimento.getSaidaRaioX() == null){
            return tempoAtendimento.getSaidaMedicacao();
        }
        return tempoAtendimento.getSaidaRaioX();
    }

}

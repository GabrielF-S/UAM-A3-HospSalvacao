package com.h_salvacao.ms_guiche.service.impl;

import com.h_salvacao.ms_guiche.feignCliente.PacienteFeignClient;
import com.h_salvacao.ms_guiche.model.Paciente;
import com.h_salvacao.ms_guiche.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteServicImpl implements PacienteService {

    private  final PacienteFeignClient pacienteFeignClient;

    @Override
    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteFeignClient.salvarPaciente(paciente);
    }

    @Override
    public Paciente atualizarpaciente(Paciente paciente) {
        return pacienteFeignClient.atualizarPaciente(paciente);
    }
}

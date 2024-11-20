package com.h_salvacao.ms_connect.service.impl;

import com.h_salvacao.ms_connect.entity.Paciente;
import com.h_salvacao.ms_connect.repository.PacienteRepository;
import com.h_salvacao.ms_connect.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;
    @Override
    public Paciente getPacienteByCpf(String cpf) {
        return  pacienteRepository.findByCpf(cpf).get();

    }
}

package com.h_salvacao.ms_connect.service.impl;

import com.h_salvacao.ms_connect.entity.Paciente;
import com.h_salvacao.ms_connect.repository.EnderecoRepository;
import com.h_salvacao.ms_connect.repository.PacienteRepository;
import com.h_salvacao.ms_connect.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;
    @Override
    public Paciente getPacienteByCpf(String cpf) {
        return  pacienteRepository.findByCpf(cpf).get();

    }

    @Override
    public Paciente salvarPaciente(Paciente paciente) {
        enderecoRepository.save(paciente.getEndereco());
        return  pacienteRepository.save(paciente);
    }

    @Override
    public Paciente atualizarPaciente(Paciente paciente) {
        Paciente pacienteDB = pacienteRepository.findById(paciente.getId()).get();
        if (pacienteDB.getEndereco() == null && paciente.getEndereco() != null){
            enderecoRepository.save(paciente.getEndereco());
        }
        return  pacienteRepository.save(paciente);

    }
}

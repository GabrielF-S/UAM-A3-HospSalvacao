package com.h_salvacao.ms_connect.service;

import com.h_salvacao.ms_connect.entity.Paciente;

public interface PacienteService {

    Paciente getPacienteByCpf(String cpf);

    Paciente salvarPaciente(Paciente paciente);

    Paciente atualizarPaciente(Paciente paciente);
}

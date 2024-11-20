package com.h_salvacao.ms_connect.service;

import com.h_salvacao.ms_connect.entity.Paciente;

public interface PacienteService {

    Paciente getPacienteByCpf(String cpf);
}

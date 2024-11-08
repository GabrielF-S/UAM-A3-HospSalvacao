package com.h_salvacao.ms_token.service;

import com.h_salvacao.ms_token.entity.Paciente;

public interface PacienteService {
    Paciente buscarPaciente(String cpf);

    Paciente pacienteSemCadastro();
}

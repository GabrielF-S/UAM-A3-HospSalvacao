package com.h_salvacao.ms_token.service;

import com.h_salvacao.ms_token.model.Paciente;

public interface PacienteService {
    Paciente buscarPaciente(String cpf);

    Paciente pacienteSemCadastro();
}

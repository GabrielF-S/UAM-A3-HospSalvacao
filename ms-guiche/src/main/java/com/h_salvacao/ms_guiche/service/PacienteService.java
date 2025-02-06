package com.h_salvacao.ms_guiche.service;

import com.h_salvacao.ms_guiche.model.Paciente;

public interface PacienteService {
    Paciente salvarPaciente(Paciente paciente);

    Paciente atualizarpaciente(Paciente paciente);
}

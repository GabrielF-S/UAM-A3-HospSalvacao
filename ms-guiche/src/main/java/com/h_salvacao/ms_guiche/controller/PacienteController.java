package com.h_salvacao.ms_guiche.controller;

import com.h_salvacao.ms_guiche.model.Paciente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public interface PacienteController {
    @PostMapping(value = "salvarPaciente")
    ResponseEntity<Paciente> salvarPaciente(Paciente paciente);

    @PutMapping(value = "atualizarPaciente")
    ResponseEntity<Paciente> atualizarPaciente(Paciente paciente);
}

package com.h_salvacao.ms_connect.controller;

import com.h_salvacao.ms_connect.entity.Paciente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface PacienteController {

    @GetMapping(value = "getCpf/{cpf}")
    ResponseEntity<Paciente> getPacienteByCpf(String cpf);


    @PostMapping(value = "salvar")
    ResponseEntity<Paciente> savePaciente(Paciente paciente);

}

package com.h_salvacao.ms_connect.controller;

import com.h_salvacao.ms_connect.entity.Paciente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface PacienteController {

    @GetMapping(value = "get")
    ResponseEntity<Paciente> getPacienteByCpf(String cpf);

}

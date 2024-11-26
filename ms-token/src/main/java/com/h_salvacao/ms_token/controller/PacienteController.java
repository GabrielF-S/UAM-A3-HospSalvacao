package com.h_salvacao.ms_token.controller;

import com.h_salvacao.ms_token.model.Paciente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface PacienteController {

    @GetMapping(value = "buscarRegistro/{cpf}")
    ResponseEntity<Paciente> buscarRegistro(@PathVariable String cpf);

}

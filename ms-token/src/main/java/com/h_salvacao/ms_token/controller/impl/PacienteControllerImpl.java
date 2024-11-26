package com.h_salvacao.ms_token.controller.impl;

import com.h_salvacao.ms_token.controller.PacienteController;
import com.h_salvacao.ms_token.model.Paciente;
import com.h_salvacao.ms_token.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "paciente")
@CrossOrigin(value = "http://localhost:4200/")
public class PacienteControllerImpl implements PacienteController {
    @Autowired
    PacienteService pacienteService;
    @Override
    public ResponseEntity<Paciente> buscarRegistro(String cpf) {
        return ResponseEntity.ok().body(pacienteService.buscarPaciente(cpf)) ;

    }
}

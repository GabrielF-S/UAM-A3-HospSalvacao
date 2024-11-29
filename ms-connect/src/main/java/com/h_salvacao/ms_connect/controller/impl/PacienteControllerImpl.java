package com.h_salvacao.ms_connect.controller.impl;

import com.h_salvacao.ms_connect.controller.PacienteController;
import com.h_salvacao.ms_connect.entity.Paciente;
import com.h_salvacao.ms_connect.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/connectPaciente")
public class PacienteControllerImpl implements PacienteController {

    @Autowired
    PacienteService pacienteService;
    @Override
    public ResponseEntity<Paciente> getPacienteByCpf(@PathVariable String cpf) {
      return ResponseEntity.ok().body(pacienteService.getPacienteByCpf(cpf));

    }

    @Override
    public ResponseEntity<Paciente> savePaciente(@RequestBody Paciente paciente) {
        return  ResponseEntity.ok().body(pacienteService.salvarPaciente(paciente));
    }

    @Override
    public ResponseEntity<Paciente> updatePaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok().body(pacienteService.atualizarPaciente(paciente));
    }
}

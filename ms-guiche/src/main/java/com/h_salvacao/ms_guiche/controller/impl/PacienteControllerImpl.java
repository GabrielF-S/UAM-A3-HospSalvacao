package com.h_salvacao.ms_guiche.controller.impl;

import com.h_salvacao.ms_guiche.controller.PacienteController;
import com.h_salvacao.ms_guiche.model.Paciente;
import com.h_salvacao.ms_guiche.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "guiche/paciente")
@CrossOrigin(value = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
public class PacienteControllerImpl implements PacienteController {
    PacienteService pacienteService;
    @Override
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok().body(pacienteService.salvarPaciente(paciente));
    }

    @Override
    public ResponseEntity<Paciente> atualizarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok().body(pacienteService.atualizarpaciente(paciente));
    }
}

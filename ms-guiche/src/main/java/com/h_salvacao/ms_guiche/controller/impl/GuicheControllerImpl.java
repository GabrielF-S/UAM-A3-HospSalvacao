package com.h_salvacao.ms_guiche.controller.impl;

import com.h_salvacao.ms_guiche.controller.GuicheController;
import com.h_salvacao.ms_guiche.model.Paciente;
import com.h_salvacao.ms_guiche.model.Token;
import com.h_salvacao.ms_guiche.service.GuicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "guiche")
@CrossOrigin(value = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
public class GuicheControllerImpl implements GuicheController {

    @Autowired
    GuicheService guicheService;
    @Override
    public ResponseEntity<Integer> getQuantidadeTotalFila() {
        return ResponseEntity.ok().body(guicheService.pegarTotal());
    }

    @Override
    public ResponseEntity<Token> getProximo() {
        return ResponseEntity.ok().body(guicheService.chamarProximo());
    }

    @Override
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok().body(guicheService.salvarPaciente(paciente));
    }

    @Override
    public ResponseEntity<Paciente> atualizarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok().body(guicheService.atualizarPaciente(paciente));
    }

    @Override
    public ResponseEntity<Token> encaminahrToken(@RequestBody Token token) {
        return  ResponseEntity.ok().body(guicheService.encaminharToken(token));
    }
}

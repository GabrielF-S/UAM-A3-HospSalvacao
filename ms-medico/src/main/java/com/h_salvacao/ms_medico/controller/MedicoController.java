package com.h_salvacao.ms_medico.controller;

import com.h_salvacao.ms_medico.service.MedicoService;
import com.h_salvacao.ms_triagem.model.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medico")
public class MedicoController {

    private final MedicoService medicoService;
    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/chamar-medico")
    public ResponseEntity<Token> chamarMedico() {
        Token token = medicoService.chamarMedico();
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.h_salvacao.ms_medico.controller.impl;

import com.h_salvacao.ms_medico.controller.MedicoController;
import com.h_salvacao.ms_medico.model.Ficha;
import com.h_salvacao.ms_medico.model.Token;
import com.h_salvacao.ms_medico.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "medico")
@CrossOrigin(value = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
public class MedicoControllerImpl implements MedicoController {

    @Autowired
    MedicoService medicoService;

    @Override
    public ResponseEntity<Integer> getQuantidadeTotalFila() {
        return ResponseEntity.ok().body(medicoService.getTotal());
    }

    @Override
    public ResponseEntity<Token> getProximo() {
        return ResponseEntity.ok().body(medicoService.chamarProximo());
    }

    @Override
    public ResponseEntity<Ficha> getFicha(@RequestParam Long tokenId) {
        return ResponseEntity.ok().body(medicoService.getFicha(tokenId));
    }

    @Override
    public ResponseEntity<Ficha> atualizarFicha(@RequestBody Ficha ficha) {
        return ResponseEntity.ok().body(medicoService.atualizarFicha(ficha));
    }
}

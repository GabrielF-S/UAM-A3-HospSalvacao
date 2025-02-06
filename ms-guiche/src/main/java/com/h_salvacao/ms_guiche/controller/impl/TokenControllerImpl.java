package com.h_salvacao.ms_guiche.controller.impl;

import com.h_salvacao.ms_guiche.controller.TokenController;
import com.h_salvacao.ms_guiche.model.Paciente;
import com.h_salvacao.ms_guiche.model.Token;
import com.h_salvacao.ms_guiche.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "guiche/token")
@CrossOrigin(value = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
public class TokenControllerImpl implements TokenController {

    @Autowired
    TokenService guicheService;
    @Override
    public ResponseEntity<Integer> getQuantidadeTotalFila() {
        return ResponseEntity.ok().body(guicheService.pegarTotal());
    }

    @Override
    public ResponseEntity<Token> getProximo() {
        return ResponseEntity.ok().body(guicheService.chamarProximo());
    }


    @Override
    public ResponseEntity<Token> encaminahrToken(@RequestBody Token token) {
        return  ResponseEntity.ok().body(guicheService.encaminharToken(token));
    }
}

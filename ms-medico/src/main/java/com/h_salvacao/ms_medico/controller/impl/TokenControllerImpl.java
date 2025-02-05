package com.h_salvacao.ms_medico.controller.impl;

import com.h_salvacao.ms_medico.controller.TokenController;
import com.h_salvacao.ms_medico.model.*;
import com.h_salvacao.ms_medico.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "medico/token")
@CrossOrigin(value = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
public class TokenControllerImpl implements TokenController {

    @Autowired
    TokenService tokenService;

    @Override
    public ResponseEntity<Integer> getQuantidadeTotalFila() {
        return ResponseEntity.ok().body(tokenService.getTotal());
    }

    @Override
    public ResponseEntity<Token> getProximo() {
        return ResponseEntity.ok().body(tokenService.chamarProximo());
    }

    @Override
    public ResponseEntity<Token> encerrarAtendimento(@RequestBody Token token) {
        return ResponseEntity.ok().body(tokenService.encerrarAtendimento(token));
    }




}

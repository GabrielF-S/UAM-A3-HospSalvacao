package com.h_salvacao.ms_triagem.controller.impl;


import com.h_salvacao.ms_triagem.controller.TokenController;
import com.h_salvacao.ms_triagem.model.Ficha;
import com.h_salvacao.ms_triagem.model.Token;
import com.h_salvacao.ms_triagem.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "triagem/token")
@CrossOrigin(value = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
public class TokenControllerImpl implements TokenController {

    @Autowired
    TokenService triagemService;
    @Override
    public ResponseEntity<Integer> getQuantidadeTotalFila() {
        return ResponseEntity.ok().body(triagemService.pegarTotal());
    }

    @Override
    public ResponseEntity<Token> getProximo() {
        return ResponseEntity.ok().body(triagemService.chamarProximo());
    }


}

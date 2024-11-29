package com.h_salvacao.ms_connect.controller.impl;

import com.h_salvacao.ms_connect.controller.TokenController;
import com.h_salvacao.ms_connect.entity.Token;
import com.h_salvacao.ms_connect.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/connectToken")
public class TokenControllerImpl implements TokenController {

    @Autowired
    TokenService tokenService;


    @Override
    public ResponseEntity<Token> salvarToken(@RequestBody  Token token) {
       return ResponseEntity.ok(tokenService.salvarToken(token));
    }

    @Override
    public ResponseEntity<Token> getTokenById(@PathVariable Long id) {
        return  ResponseEntity.ok().body(tokenService.getToken(id));
    }

    @Override
    public ResponseEntity<Token> getToken(@PathVariable String numToken) {
        return ResponseEntity.ok().body(tokenService.getByToken(numToken));
    }

    @Override
    public ResponseEntity<List<Token>> getAllTokens() {
          return new ResponseEntity<>(tokenService.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Token> updateToken(@RequestBody  Token token) {
        return  ResponseEntity.ok().body(tokenService.atualizarToken(token));
    }


}

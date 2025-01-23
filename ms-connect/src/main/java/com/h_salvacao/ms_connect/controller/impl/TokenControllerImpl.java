package com.h_salvacao.ms_connect.controller.impl;

import com.h_salvacao.ms_connect.controller.TokenController;
import com.h_salvacao.ms_connect.entity.MyList;
import com.h_salvacao.ms_connect.entity.Token;
import com.h_salvacao.ms_connect.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/connectToken")
public class TokenControllerImpl implements TokenController {

    @Autowired
    TokenService tokenService;


    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarToken(@RequestBody  Token token) {
       tokenService.salvarToken(token);
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
    public ResponseEntity<MyList> getAllTokens() {
          return new ResponseEntity<>(tokenService.getAll(), HttpStatus.OK);
    }


    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public void updateToken(@RequestBody  Token token) {
        tokenService.atualizarToken(token);
    }

}

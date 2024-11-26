package com.h_salvacao.ms_token.controller.impl;

import com.h_salvacao.ms_token.controller.TokenController;
import com.h_salvacao.ms_token.model.Token;
import com.h_salvacao.ms_token.model.TokenAtendimento;
import com.h_salvacao.ms_token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/token")
@CrossOrigin(value = "http://localhost:4200/")
public class TokenControllerImpl implements TokenController {
    @Autowired
    TokenService tokenService;


    @Override
    public ResponseEntity<Token> gerarToken(@RequestBody TokenAtendimento atendimento) {

        Token token;
        if (atendimento.getCpf() == null){
          token =   tokenService.abrirFichaSemCadastro(atendimento.getTipoAtendimento());
        }else {
             token =   tokenService.abrirFicha(atendimento.getCpf(), atendimento.getTipoAtendimento());
        }


        return  ResponseEntity.ok().body(tokenService.salvarToken(token));
    }

    @Override
    public ResponseEntity<Token> salvarToken(Token token) {
        return null;
    }
}

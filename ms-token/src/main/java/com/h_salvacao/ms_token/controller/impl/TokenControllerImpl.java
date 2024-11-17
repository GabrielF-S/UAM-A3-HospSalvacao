package com.h_salvacao.ms_token.controller.impl;

import com.h_salvacao.ms_token.controller.TokenController;
import com.h_salvacao.ms_token.entity.Token;
import com.h_salvacao.ms_token.entity.TokenAtendimento;
import com.h_salvacao.ms_token.service.TokenProducerSender;
import com.h_salvacao.ms_token.service.TokenService;
import com.h_salvacao.ms_token.service.ImprimirFichaService;
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
    TokenService fichaService;
    @Autowired
    ImprimirFichaService imprimirFichaService;

    @Autowired
    TokenProducerSender tokenProducerSender;
    @Override
    public ResponseEntity<Token> gerarToken(@RequestBody TokenAtendimento atendimento) {

        Token token;
        if (atendimento.getCpf() == null){
          token =   fichaService.abrirFichaSemCadastro(atendimento.getTipoAtendimento());
        }else {
             token =   fichaService.abrirFicha(atendimento.getCpf(), atendimento.getTipoAtendimento());
        }
        fichaService.salvarFicha(token);
        imprimirFichaService.Imprimir(token);
        tokenProducerSender.sendToken(token);
        return  ResponseEntity.ok(token);
    }

    @Override
    public ResponseEntity<Token> salvarToken(Token token) {
        return null;
    }
}

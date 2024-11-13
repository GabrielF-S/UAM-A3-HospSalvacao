package com.h_salvacao.ms_token.controller.impl;

import com.h_salvacao.ms_token.controller.TokenController;
import com.h_salvacao.ms_token.entity.Token;
import com.h_salvacao.ms_token.entity.TokenAtendimento;
import com.h_salvacao.ms_token.service.FichaService;
import com.h_salvacao.ms_token.service.ImprimirFichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/token")
public class TokenControllerImpl implements TokenController {
    @Autowired
    FichaService fichaService;
    @Autowired
    ImprimirFichaService imprimirFichaService;
    @Override
    public ResponseEntity<Token> gerarFicha(@RequestBody TokenAtendimento atendimento) {

        Token token;
        if (atendimento.getCpf() == null){
          token =   fichaService.abrirFichaSemCadastro(atendimento.getTipoAtendimento());
        }else {
             token =   fichaService.abrirFicha(atendimento.getCpf(), atendimento.getTipoAtendimento());
        }
        fichaService.salvarFicha(token);
        imprimirFichaService.Imprimir(token);
        return  ResponseEntity.ok(token);
    }

    @Override
    public ResponseEntity<Token> salvarFicha(Token token) {
        return null;
    }
}

package com.h_salvacao.ms_triagem.controller.impl;


import com.h_salvacao.ms_triagem.controller.TriagemController;
import com.h_salvacao.ms_triagem.model.Ficha;
import com.h_salvacao.ms_triagem.model.Token;
import com.h_salvacao.ms_triagem.service.TriagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "triagem")
@CrossOrigin(value = "http://localhost:4200/")
public class TriagemControllerImpl implements TriagemController {

    @Autowired
    TriagemService triagemService;
    @Override
    public ResponseEntity<Integer> getQuantidadeTotalFila() {
        return ResponseEntity.ok().body(triagemService.pegarTotal());
    }

    @Override
    public ResponseEntity<Token> getProximo() {
        return ResponseEntity.ok().body(triagemService.chamarProximo());
    }

    @Override
    public ResponseEntity<Ficha> abrirFicha(@RequestBody Ficha ficha) {
        triagemService.atualizarToken(ficha);
        return ResponseEntity.ok().body(triagemService.enviarFicha(ficha));
    }
}

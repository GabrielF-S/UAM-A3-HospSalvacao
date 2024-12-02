package com.h_salvacao.ms_connect.controller.impl;

import com.h_salvacao.ms_connect.controller.FichaController;
import com.h_salvacao.ms_connect.entity.Ficha;
import com.h_salvacao.ms_connect.service.FichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/connectFicha")
public class FichaControllerImpl implements FichaController {
    @Autowired
    FichaService fichaService;
    @Override
    public ResponseEntity<Ficha> salvarFicha(Ficha ficha) {
        return ResponseEntity.ok().body(fichaService.salvarFicha(ficha));
    }

    @Override
    public ResponseEntity<Ficha> getFicha(Long tokenId) {
        return  ResponseEntity.ok().body(fichaService.getFicha(tokenId));
    }

    @Override
    public ResponseEntity<Ficha> atualizarFicha(Ficha ficha) {
        return ResponseEntity.ok().body(fichaService.atualizarFicha(ficha));
    }
}

package com.h_salvacao.ms_triagem.controller.impl;

import com.h_salvacao.ms_triagem.controller.FichaController;
import com.h_salvacao.ms_triagem.model.Ficha;
import com.h_salvacao.ms_triagem.service.FichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "triagem/ficha")
@CrossOrigin(value = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
public class FichaControllerImpl implements FichaController {
    @Autowired
    FichaService fichaService;
    @Override
    public ResponseEntity<Ficha> abrirFichaEncaminharPaciente(@RequestBody Ficha ficha) {
        return ResponseEntity.ok().body(fichaService.enviarFicha(ficha));
    }
}

package com.h_salvacao.ms_medico.controller.impl;

import com.h_salvacao.ms_medico.controller.FichaController;
import com.h_salvacao.ms_medico.model.Ficha;
import com.h_salvacao.ms_medico.service.FichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "medico/ficha")
@CrossOrigin(value = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
public class FichaControllerImpl implements FichaController {

    @Autowired
    FichaService fichaService;

    @Override
    public ResponseEntity<Ficha> getFicha(@PathVariable Long tokenId) {
        return ResponseEntity.ok().body(fichaService.getFicha(tokenId));
    }

    @Override
    public ResponseEntity<Ficha> atualizarFicha(@RequestBody  Ficha ficha) {
        return ResponseEntity.ok().body(fichaService.atulizarFicha(ficha));
    }
}

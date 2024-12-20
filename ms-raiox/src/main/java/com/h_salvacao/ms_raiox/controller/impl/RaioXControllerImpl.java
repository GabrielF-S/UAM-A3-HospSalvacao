package com.h_salvacao.ms_raiox.controller.impl;

import com.h_salvacao.ms_raiox.controller.RaioXController;
import com.h_salvacao.ms_raiox.model.Encaminhamento;
import com.h_salvacao.ms_raiox.service.RaioXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "raiox")
@CrossOrigin(value = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
public class RaioXControllerImpl implements RaioXController {

    @Autowired
    RaioXService raioXService;
    @Override
    public ResponseEntity<Integer> getQuantidadeTotalFila() {
        return ResponseEntity.ok().body(raioXService.getTotal());
    }

    @Override
    public ResponseEntity<Encaminhamento> getProximo() {
        return ResponseEntity.ok().body(raioXService.chamarProximo());
    }

    @Override
    public void encaminahrToken(Encaminhamento encaminhamento) {
         raioXService.encaminharPaciente(encaminhamento);
    }
}

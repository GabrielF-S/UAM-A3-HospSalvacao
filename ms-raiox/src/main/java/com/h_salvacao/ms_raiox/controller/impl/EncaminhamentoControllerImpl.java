package com.h_salvacao.ms_raiox.controller.impl;

import com.h_salvacao.ms_raiox.controller.EncaminhamentoController;
import com.h_salvacao.ms_raiox.model.Encaminhamento;
import com.h_salvacao.ms_raiox.service.EncaminhamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "raiox/encaminhamento")
@CrossOrigin(value = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
public class EncaminhamentoControllerImpl implements EncaminhamentoController {

    @Autowired
    EncaminhamentoService raioXService;
    @Override
    public ResponseEntity<Integer> getQuantidadeTotalFila() {
        return ResponseEntity.ok().body(raioXService.getTotal());
    }

    @Override
    public ResponseEntity<Encaminhamento> getProximo() {
        return ResponseEntity.ok().body(raioXService.chamarProximo());
    }

    @Override
    public void encaminahrPaciente(@RequestBody Encaminhamento encaminhamento) {
         raioXService.encaminharPaciente(encaminhamento);
    }
}

package com.h_salvacao.ms_medicacao.controller.impl;

import com.h_salvacao.ms_medicacao.controller.EncaminhamentoController;
import com.h_salvacao.ms_medicacao.model.Encaminhamento;
import com.h_salvacao.ms_medicacao.util.Queue;
import com.h_salvacao.ms_medicacao.services.EncaminhamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "medicacao/encaminhamento")
@CrossOrigin(value = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
public class EncaminhamentoControllerImpl implements EncaminhamentoController {

    @Autowired
    EncaminhamentoService service;

    @Override
    public ResponseEntity<Integer> getQuantidadeTotalFila() {
        return  ResponseEntity.ok().body(service.getQtd());

    }

    @Override
    public ResponseEntity<Encaminhamento> getProximo() {
        return ResponseEntity.ok().body(service.getProximo());
    }

    @Override
    public void encaminahrPaciente(@RequestBody Encaminhamento encaminhamento) {
        service.encaminharPaciente(encaminhamento);

    }

    @Override
    public ResponseEntity<Queue<Encaminhamento>> getLista() {
        return ResponseEntity.ok().body(service.getLista());
    }
}

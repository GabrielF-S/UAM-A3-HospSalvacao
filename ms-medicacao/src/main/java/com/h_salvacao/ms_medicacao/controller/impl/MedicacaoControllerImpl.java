package com.h_salvacao.ms_medicacao.controller.impl;

import com.h_salvacao.ms_medicacao.controller.MedicacaoController;
import com.h_salvacao.ms_medicacao.model.Encaminhamento;
import com.h_salvacao.ms_medicacao.services.MedicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "medicacao")
@CrossOrigin(value = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
public class MedicacaoControllerImpl implements MedicacaoController {

    @Autowired
    MedicacaoService service;

    @Override
    public ResponseEntity<Integer> getQuantidadeTotalFila() {
        return  ResponseEntity.ok().body(service.getQtd());

    }

    @Override
    public ResponseEntity<Encaminhamento> getProximo() {
        return ResponseEntity.ok().body(service.getProximo());
    }

    @Override
    public void encaminahrPaciente(Encaminhamento encaminhamento) {
        service.encaminharPaciente(encaminhamento);

    }
}

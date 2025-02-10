package com.h_salvacao.ms_connect.controller.impl;

import com.h_salvacao.ms_connect.controller.TempoAtendimentoController;
import com.h_salvacao.ms_connect.entity.TempoAtendimento;
import com.h_salvacao.ms_connect.entity.Token;
import com.h_salvacao.ms_connect.service.TempoAtenidmentoService;
import com.h_salvacao.ms_connect.util.PeriodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/connectAtendimento")
public class TempoAtendimentoControllerImpl implements TempoAtendimentoController{

    @Autowired
    TempoAtenidmentoService service;

    @Override
    public ResponseEntity<TempoAtendimento> getTempoAtendimento(@PathVariable String numToken) {
        return ResponseEntity.ok().body(service.getByNumToken(numToken)) ;
    }

    @Override
    public ResponseEntity<List<TempoAtendimento>> getAllAtendimentoDoDia() {
        return  ResponseEntity.ok().body(service.getAllAtendimentosDoDia());
    }

    @Override
    public ResponseEntity<List<TempoAtendimento>> getAllAtendimentoPorPeriodo(@RequestBody PeriodoRequest periodo) {
        return ResponseEntity.ok().body(service.getAtendimentoPorPeriodo(periodo.getDataInicio(), periodo.getDataFinal()));
    }

    @Override
    public ResponseEntity<TempoAtendimento> updateAtendimento(@RequestBody  TempoAtendimento atendimento) {
        return ResponseEntity.ok().body(service.updateAtendimento(atendimento));
    }
}

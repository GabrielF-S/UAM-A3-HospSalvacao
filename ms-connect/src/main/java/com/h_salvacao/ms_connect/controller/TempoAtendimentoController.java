package com.h_salvacao.ms_connect.controller;

import com.h_salvacao.ms_connect.entity.TempoAtendimento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

public interface TempoAtendimentoController {

    @GetMapping(value = "/getAtendimento/{numToken}")
    ResponseEntity<TempoAtendimento> getTempoAtendimento(String numToken);

    @PutMapping(value = "updateAtendimento")
    ResponseEntity<TempoAtendimento> updateAtendimento(TempoAtendimento atendimento);

}

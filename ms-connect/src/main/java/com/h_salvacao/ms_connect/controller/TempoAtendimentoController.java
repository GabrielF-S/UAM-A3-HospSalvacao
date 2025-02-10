package com.h_salvacao.ms_connect.controller;

import com.h_salvacao.ms_connect.entity.TempoAtendimento;
import com.h_salvacao.ms_connect.util.PeriodoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDate;
import java.util.List;

public interface TempoAtendimentoController {

    @GetMapping(value = "/getAtendimento/{numToken}")
    ResponseEntity<TempoAtendimento> getTempoAtendimento(String numToken);

    @GetMapping(value = "/getAtendimento")
    ResponseEntity<List<TempoAtendimento>> getAllAtendimentoDoDia();

    @GetMapping(value = "/getAtendimento/porPeriodo")
    ResponseEntity<List<TempoAtendimento>> getAllAtendimentoPorPeriodo(PeriodoRequest periodo);

    @PutMapping(value = "updateAtendimento")
    ResponseEntity<TempoAtendimento> updateAtendimento(TempoAtendimento atendimento);

}

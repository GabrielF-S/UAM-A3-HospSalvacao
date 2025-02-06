package com.h_salvacao.ms_raiox.controller;

import com.h_salvacao.ms_raiox.model.Encaminhamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface EncaminhamentoController {
    @GetMapping(value = "getQtd")
    ResponseEntity<Integer> getQuantidadeTotalFila();

    @GetMapping(value = "getProximo")
    ResponseEntity<Encaminhamento> getProximo();

    @PostMapping(value = "encaminharPaciente")
    void encaminahrPaciente(@RequestBody  Encaminhamento encaminhamento);



}

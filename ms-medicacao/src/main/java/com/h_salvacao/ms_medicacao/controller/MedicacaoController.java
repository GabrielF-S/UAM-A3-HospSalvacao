package com.h_salvacao.ms_medicacao.controller;

import com.h_salvacao.ms_medicacao.model.Encaminhamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MedicacaoController {
    @GetMapping(value = "getQtd")
    ResponseEntity<Integer> getQuantidadeTotalFila();

    @GetMapping(value = "getProximo")
    ResponseEntity<Encaminhamento> getProximo();

    @PostMapping(value = "encaminharPaciente")
    void encaminahrPaciente(@RequestBody Encaminhamento encaminhamento);

}

package com.h_salvacao.ms_medico.controller;

import com.h_salvacao.ms_medico.model.Encaminhamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface EncaminhamentoController {

    @PostMapping(value = "encaminharPaciente")
    ResponseEntity<?> encaminharPaciente(Encaminhamento encaminhamento);


    @GetMapping(value = "getEncaminhamento/{numToken}")
    ResponseEntity<Encaminhamento> getEncaminhamento(@PathVariable("numToken") String numToken);
}

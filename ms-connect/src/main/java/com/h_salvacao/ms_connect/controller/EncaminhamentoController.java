package com.h_salvacao.ms_connect.controller;

import com.h_salvacao.ms_connect.entity.Encaminhamento;
import com.h_salvacao.ms_connect.entity.Ficha;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface EncaminhamentoController {

    @PostMapping(value = "save")
    ResponseEntity<Encaminhamento> salvarEncaminhamento(@RequestBody Encaminhamento encaminhamento);

    @GetMapping(value = "get/{numToken}")
    ResponseEntity<Encaminhamento> getEncaminhamento(@PathVariable("numToken") String numToken);

}

package com.h_salvacao.ms_connect.controller;

import com.h_salvacao.ms_connect.entity.Encaminhamento;
import com.h_salvacao.ms_connect.entity.Ficha;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface EncaminhamentoController {

    @PostMapping(value = "save")
    ResponseEntity<Encaminhamento> salvarEncaminhamento(@RequestBody Encaminhamento encaminhamento);

    @GetMapping(value = "get/{numToken}")
    ResponseEntity<Encaminhamento> getEncaminhamento(@PathVariable("numToken") String numToken);

    @PutMapping(value = "update")
    ResponseEntity<Encaminhamento> updateEncaminhamento(@RequestBody Encaminhamento encaminhamento);

}

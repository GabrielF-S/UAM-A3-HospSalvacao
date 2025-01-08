package com.h_salvacao.ms_connect.controller.impl;

import com.h_salvacao.ms_connect.controller.EncaminhamentoController;
import com.h_salvacao.ms_connect.entity.Encaminhamento;
import com.h_salvacao.ms_connect.service.EncaminhamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/connectEncaminhamento")
@AllArgsConstructor
public class EncaminhamentoControllerImpl implements EncaminhamentoController  {
    private final EncaminhamentoService encaminhamentoService;

    @Override
    public ResponseEntity<Encaminhamento> salvarEncaminhamento(Encaminhamento encaminhamento) {
        return  ResponseEntity.ok().body(encaminhamentoService.save(encaminhamento));
    }
}

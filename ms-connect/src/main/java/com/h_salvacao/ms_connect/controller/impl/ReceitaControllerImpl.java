package com.h_salvacao.ms_connect.controller.impl;

import com.h_salvacao.ms_connect.controller.ReceitaController;
import com.h_salvacao.ms_connect.entity.Receita;
import com.h_salvacao.ms_connect.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/connectReceita")
public class ReceitaControllerImpl implements ReceitaController {
    @Autowired
    ReceitaService receitaService;

    @Override
    public ResponseEntity<?> salvarReceita(Receita receita) {
        return ResponseEntity.ok().body(receitaService.save(receita));
    }
}

package com.h_salvacao.ms_medico.controller.impl;

import com.h_salvacao.ms_medico.controller.ReceitaController;
import com.h_salvacao.ms_medico.model.Receita;
import com.h_salvacao.ms_medico.service.FichaService;
import com.h_salvacao.ms_medico.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "medico/receita")
@CrossOrigin(value = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
public class ReceitaControllerImpl implements ReceitaController {

    @Autowired
    ReceitaService receitaService;
    @Override
    public ResponseEntity<?> salvarReceita(@RequestBody Receita receita) {
        return ResponseEntity.ok().body(receitaService.salvarReceita(receita));
    }

    @Override
    public void imprimirReceita(@RequestBody Receita receita) {
        receitaService.imprimir(receita);

    }
}

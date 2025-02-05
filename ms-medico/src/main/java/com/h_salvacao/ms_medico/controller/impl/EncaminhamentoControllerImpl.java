package com.h_salvacao.ms_medico.controller.impl;

import com.h_salvacao.ms_medico.controller.EncaminhamentoController;
import com.h_salvacao.ms_medico.model.Encaminhamento;
import com.h_salvacao.ms_medico.service.EncaminhamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "medico/encaminhamento")
@CrossOrigin(value = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
public class EncaminhamentoControllerImpl implements EncaminhamentoController {
    EncaminhamentoService encaminhamentoService;

    @Override
    public ResponseEntity<?> encaminharPaciente(@RequestBody Encaminhamento encaminhamento) {
        return ResponseEntity.ok().body(encaminhamentoService.encaminharPaciente(encaminhamento));
    }

    @Override
    public ResponseEntity<Encaminhamento> getEncaminhamento(@PathVariable("numToken") String numToken) {
        return ResponseEntity.ok().body(encaminhamentoService.getEncaminhamento(numToken));
    }
}

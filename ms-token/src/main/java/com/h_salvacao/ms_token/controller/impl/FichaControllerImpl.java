package com.h_salvacao.ms_token.controller.impl;

import com.h_salvacao.ms_token.controller.FichaController;
import com.h_salvacao.ms_token.entity.Ficha;
import com.h_salvacao.ms_token.entity.FichaAtendimento;
import com.h_salvacao.ms_token.service.FichaService;
import com.h_salvacao.ms_token.service.ImprimirFichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ficha")
public class FichaControllerImpl implements FichaController {
    @Autowired
    FichaService fichaService;
    @Autowired
    ImprimirFichaService imprimirFichaService;
    @Override
    public ResponseEntity<Ficha> gerarFicha( @RequestBody FichaAtendimento atendimento) {

        Ficha ficha;
        if (atendimento.getCpf() == null){
          ficha =   fichaService.abrirFichaSemCadastro(atendimento.getTipoAtendimento());
        }else {
             ficha =   fichaService.abrirFicha(atendimento.getCpf(), atendimento.getTipoAtendimento());
        }
        fichaService.salvarFicha(ficha);
        imprimirFichaService.Imprimir(ficha);
        return  ResponseEntity.ok(ficha);
    }

    @Override
    public ResponseEntity<Ficha> salvarFicha(Ficha ficha) {
        return null;
    }
}

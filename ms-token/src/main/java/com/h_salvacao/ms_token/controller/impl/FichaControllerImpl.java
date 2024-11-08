package com.h_salvacao.ms_token.controller;

import com.h_salvacao.ms_token.entity.Ficha;
import com.h_salvacao.ms_token.entity.TipoAtendimento;
import com.h_salvacao.ms_token.service.FichaService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ficha")
public class implFichaControllerImpl implements  FichaController{
    @Autowired
    FichaService fichaService;
    @Override
    public ResponseEntity<Ficha> gerarFicha(FichaAtendimento atendimento) {
        Ficha ficha;
        if (atendimento.cpf == null){
          ficha =   fichaService.abrirFichaSemCadastro(atendimento);
        }else {
             ficha =   fichaService.abrirFicha(atendimento);
        }
        return  ResponseEntity.ok(ficha);
    }
}

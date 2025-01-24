package com.h_salvacao.ms_medico.controller;

import com.h_salvacao.ms_medico.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MedicoController {

    @GetMapping(value = "getQtd")
    ResponseEntity<Integer> getQuantidadeTotalFila();

    @GetMapping(value = "getProximo")
    ResponseEntity<Token> getProximo();

    @GetMapping(value = "getFicha/{tokenId}")
    ResponseEntity<Ficha> getFicha(@PathVariable("tokenId") Long tokenId);

    @PostMapping(value = "atualizarFicha")
    ResponseEntity<Ficha> atualizarFicha(Ficha ficha);

    @PostMapping(value = "salvarReceita")
    ResponseEntity<?> salvarReceita(Receita receita);

    @PostMapping(value = "imprimirReceita")
    void imprimirReceita(Receita receita);

    @PostMapping(value = "encaminharPaciente")
    ResponseEntity<?> encaminharPaciente(Encaminhamento encaminhamento);


    @PostMapping(value = "encerrarAtendimento")
    ResponseEntity<Token> encerrarAtendimento(Token token);

    @GetMapping(value = "getEncaminhamento/{numToken}")
    ResponseEntity<Encaminhamento> getEncaminhamento(@PathVariable("numToken") String numToken);

}

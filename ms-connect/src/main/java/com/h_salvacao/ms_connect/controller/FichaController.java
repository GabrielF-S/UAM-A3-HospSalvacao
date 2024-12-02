package com.h_salvacao.ms_connect.controller;

import com.h_salvacao.ms_connect.entity.Ficha;
import com.h_salvacao.ms_connect.entity.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface FichaController {

    @PostMapping(value = "save")
    ResponseEntity<Ficha> salvarFicha(@RequestBody Ficha ficha);


    @GetMapping(value = "get/{tokenId}")
    ResponseEntity<Ficha> getFicha(@RequestParam Long tokenId);

    @PostMapping(value = "update")
    ResponseEntity<Ficha> atualizarFicha(@RequestBody Ficha ficha);

}

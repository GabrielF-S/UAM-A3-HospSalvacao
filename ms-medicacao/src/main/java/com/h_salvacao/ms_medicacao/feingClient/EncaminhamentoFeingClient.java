package com.h_salvacao.ms_medicacao.feingClient;

import com.h_salvacao.ms_medicacao.model.Encaminhamento;
import com.h_salvacao.ms_medicacao.model.TempoAtendimento;
import com.h_salvacao.ms_medicacao.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "ms-connect/connectEncaminhamento", url ="http://localhost:8001")
public interface EncaminhamentoFeingClient {
    @GetMapping(value = "connectToken/getToken/{tokenNumber}")
    ResponseEntity<Token> getToken(@PathVariable("tokenNumber")  String tokenNumber);

    @PostMapping("/save")
    ResponseEntity<Encaminhamento> saveEncaminhamento(@RequestBody Encaminhamento encaminhamento);


    @GetMapping(value = "/get/{numToken}")
    Encaminhamento getEncaminhamento(@PathVariable("numToken")  String numToken);

    @PutMapping(value = "/update")
    Encaminhamento updateEncaminhamento(@RequestBody Encaminhamento encaminhamento);



}

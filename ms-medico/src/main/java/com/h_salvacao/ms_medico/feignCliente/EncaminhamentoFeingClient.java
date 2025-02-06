package com.h_salvacao.ms_medico.feignCliente;

import com.h_salvacao.ms_medico.model.Encaminhamento;
import com.h_salvacao.ms_medico.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "ms-connect/connectEncaminhamento", url ="http://localhost:8001/connectEncaminhamento")
public interface EncaminhamentoFeingClient {

    @PostMapping("/save")
    ResponseEntity<Encaminhamento> saveEncaminhamento(@RequestBody Encaminhamento encaminhamento);


    @GetMapping(value = "/get/{numToken}")
    Encaminhamento getEncaminhamento(@PathVariable("numToken")  String numToken);

    @PutMapping(value = "/update")
    Encaminhamento updateEncaminhamento(@RequestBody Encaminhamento encaminhamento);



}

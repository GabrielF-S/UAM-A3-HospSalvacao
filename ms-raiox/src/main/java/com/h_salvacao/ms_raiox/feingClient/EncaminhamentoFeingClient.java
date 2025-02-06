package com.h_salvacao.ms_raiox.feingClient;


import com.h_salvacao.ms_raiox.model.Encaminhamento;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "ms-connect/connectEncaminhamento", url ="http://localhost:8001/connectEncaminhamento")
public interface EncaminhamentoFeingClient {



    @GetMapping(value = "/get/{numToken}")
    Encaminhamento getEncaminhamento(@PathVariable("numToken")  String numToken);

    @PutMapping(value = "/update")
    Encaminhamento updateEncaminhamento(@RequestBody Encaminhamento encaminhamento);



}

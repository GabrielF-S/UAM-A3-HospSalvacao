package com.h_salvacao.ms_medico.feignCliente;

import com.h_salvacao.ms_medico.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.net.CacheRequest;

@Component
@FeignClient(name = "ms-connect", url ="http://localhost:8001")
public interface MedicoFeignClient {

    @GetMapping(value = "connectToken/getToken/{tokenNumber}")
    ResponseEntity<Token> getToken(@PathVariable("tokenNumber")  String tokenNumber);

    @GetMapping(value = "connectFicha/get/{tokenId}")
    Ficha getFicha(@PathVariable("tokenId") Long tokenId);

    @PostMapping(value = "connectFicha/update")
    Ficha atulizarFicha(Ficha ficha);

    @PostMapping(value = "connectReceita/salvar")
    Receita salvarReceita(@RequestBody Receita receita);

    @PutMapping(value = "connectToken/updateToken")
    Token updateToken( Token token);

    @GetMapping(value = "connectAtendimento/getAtendimento/{numToken}")
    TempoAtendimento getTempoAtendimento(@PathVariable("numToken")  String numToken);

    @PutMapping(value = "connectAtendimento/updateAtendimento")
    void updateAtendimento(@RequestBody TempoAtendimento atendimento);

    @GetMapping(value = "connectEncaminhamento/get/{numToken}")
    Encaminhamento getEncaminhamento(@PathVariable("numToken")  String numToken);
}

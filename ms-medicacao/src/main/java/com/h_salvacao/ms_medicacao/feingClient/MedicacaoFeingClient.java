package com.h_salvacao.ms_medicacao.feingClient;

import com.h_salvacao.ms_medicacao.model.Encaminhamento;
import com.h_salvacao.ms_medicacao.model.TempoAtendimento;
import com.h_salvacao.ms_medicacao.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "ms-connect", url ="http://localhost:8001")
public interface MedicacaoFeingClient {
    @GetMapping(value = "connectToken/getToken/{tokenNumber}")
    ResponseEntity<Token> getToken(@PathVariable("tokenNumber")  String tokenNumber);

    @PostMapping("connectEncaminhamento/save")
    ResponseEntity<Encaminhamento> saveEncaminhamento(@RequestBody Encaminhamento encaminhamento);

    @PutMapping(value = "connectToken/updateToken")
    Token updateToken( Token token);

    @GetMapping(value = "connectAtendimento/getAtendimento/{numToken}")
    TempoAtendimento getTempoAtendimento(@PathVariable("numToken")  String numToken);

    @PutMapping(value = "connectAtendimento/updateAtendimento")
    void updateAtendimento(@RequestBody TempoAtendimento atendimento);

    @GetMapping(value = "connectEncaminhamento/get/{numToken}")
    Encaminhamento getEncaminhamento(@PathVariable("numToken")  String numToken);

    @PutMapping(value = "connectEncaminhamento/update")
    Encaminhamento updateEncaminhamento(@RequestBody Encaminhamento encaminhamento);



}

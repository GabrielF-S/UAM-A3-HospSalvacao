package com.h_salvacao.ms_raiox.feingClient;

import com.h_salvacao.ms_raiox.model.Encaminhamento;
import com.h_salvacao.ms_raiox.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "ms-connect", url ="http://localhost:8001")
public interface raioXFeingClient {

    @GetMapping(value = "connectToken/getToken/{tokenNumber}")
    ResponseEntity<Token> getToken(@PathVariable("tokenNumber")  String tokenNumber);

    @PostMapping("connectEncaminhamento/save")
    ResponseEntity<Encaminhamento> saveEncaminhamento(@RequestBody Encaminhamento encaminhamento);
    @PutMapping(value = "connectToken/updateToken")
    Token updateToken( Token token);
}

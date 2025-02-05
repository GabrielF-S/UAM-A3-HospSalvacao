package com.h_salvacao.ms_medicacao.feingClient;

import com.h_salvacao.ms_medicacao.model.Encaminhamento;
import com.h_salvacao.ms_medicacao.model.TempoAtendimento;
import com.h_salvacao.ms_medicacao.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "ms-connect/connectToken", url ="http://localhost:8001")
public interface TokenFeignClient {
    @GetMapping(value = "/getToken/{tokenNumber}")
    ResponseEntity<Token> getToken(@PathVariable("tokenNumber") String tokenNumber);


    @PutMapping(value = "/updateToken")
    Token updateToken(Token token);
}



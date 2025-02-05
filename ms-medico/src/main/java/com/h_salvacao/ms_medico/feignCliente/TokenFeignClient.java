package com.h_salvacao.ms_medico.feignCliente;

import com.h_salvacao.ms_medico.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Component
@FeignClient(name = "ms-connect/connectToken", url ="http://localhost:8001")
public interface TokenFeignClient {
    @GetMapping(value = "/getToken/{tokenNumber}")
    ResponseEntity<Token> getToken(@PathVariable("tokenNumber") String tokenNumber);


    @PutMapping(value = "/updateToken")
    Token updateToken(Token token);
}



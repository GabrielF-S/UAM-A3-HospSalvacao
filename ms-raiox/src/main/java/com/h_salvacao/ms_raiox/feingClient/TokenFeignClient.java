package com.h_salvacao.ms_raiox.feingClient;


import com.h_salvacao.ms_raiox.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Component
@FeignClient(name = "ms-connect/connectToken", url ="http://localhost:8001/connectToken")
public interface TokenFeignClient {
    @GetMapping(value = "/getToken/{tokenNumber}")
    ResponseEntity<Token> getToken(@PathVariable("tokenNumber") String tokenNumber);


    @PutMapping(value = "/updateToken")
    Token updateToken(Token token);
}



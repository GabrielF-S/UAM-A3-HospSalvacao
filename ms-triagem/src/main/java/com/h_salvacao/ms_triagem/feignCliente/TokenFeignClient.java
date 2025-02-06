package com.h_salvacao.ms_triagem.feignCliente;

import com.h_salvacao.ms_triagem.model.Ficha;
import com.h_salvacao.ms_triagem.model.TempoAtendimento;
import com.h_salvacao.ms_triagem.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(name = "ms-connect/connectToken", url ="http://localhost:8001")
public interface TokenFeignClient {

    @GetMapping(value = "/get/{id}")
    ResponseEntity<Token> getToken(Long id);

    @GetMapping(value ="/get")
    ResponseEntity<List<Token>> getAllTokens();

    @GetMapping(value = "/getToken/{tokenNumber}")
    ResponseEntity<Token> getToken(@PathVariable("tokenNumber")  String tokenNumber);


    @PutMapping(value ="/updateToken")
    Token updateToken(@RequestBody  Token token);


}

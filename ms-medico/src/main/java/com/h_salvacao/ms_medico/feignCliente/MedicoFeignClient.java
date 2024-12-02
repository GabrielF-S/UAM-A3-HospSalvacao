package com.h_salvacao.ms_medico.feignCliente;

import com.h_salvacao.ms_medico.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(name = "ms-connect", url ="http://localhost:8001")
public interface MedicoFeignClient {

    @GetMapping(value = "connectToken/get/{id}")
    ResponseEntity<Token> getToken(Long id);

    @GetMapping(value ="connectToken/get")
    ResponseEntity<List<Token>> getAllTokens();

    @GetMapping(value = "connectToken/getToken/{token}")
    ResponseEntity<Token> getToken(String tokenNumber);


}
package com.h_salvacao.ms_raiox.feingClient;

import com.h_salvacao.ms_raiox.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "ms-connect", url ="http://localhost:8001")
public interface raioXFeingClient {

    @GetMapping(value = "connectToken/getToken/{tokenNumber}")
    ResponseEntity<Token> getToken(@PathVariable("tokenNumber")  String tokenNumber);
}

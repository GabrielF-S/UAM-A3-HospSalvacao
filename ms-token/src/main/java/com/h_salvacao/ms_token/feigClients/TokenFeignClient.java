package com.h_salvacao.ms_token.feigClients;

import com.h_salvacao.ms_token.model.Paciente;
import com.h_salvacao.ms_token.model.Token;
import org.apache.kafka.streams.processor.To;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.net.CacheRequest;

@Component
@FeignClient(name = "ms-connect/token", url ="http://localhost:8001/connectToken")
public interface TokenFeignClient {

    @PostMapping(value = "/save")
    ResponseEntity<Token> salvarToken(Token token);

    @PutMapping(value = "/updateToken")
    ResponseEntity<Token> atualizarToken(Token token);
}

package com.h_salvacao.ms_token.feigClients;

import com.h_salvacao.ms_token.model.Paciente;
import com.h_salvacao.ms_token.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "ms-connect", url ="http://localhost:8001")
public interface TokenFeignClient {

    @PostMapping(value = "connectToken/save")
    ResponseEntity<Token> salvarToken(Token token);


    @GetMapping(value = "connectPaciente/get")
    ResponseEntity<Paciente> getPaciente(String cpf);

}

package com.h_salvacao.ms_guiche.feignCliente;

import com.h_salvacao.ms_guiche.model.Paciente;
import com.h_salvacao.ms_guiche.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "ms-connect", url ="http://localhost:8001")
public interface GuicheFeignCliente {

    @GetMapping(value = "connectToken/getToken/{tokenNumber}")
    ResponseEntity<Token> getToken(@PathVariable("tokenNumber")  String tokenNumber);

    @PostMapping(value = "connectPaciente/salvar")
    Paciente salvarPaciente(@RequestBody Paciente paciente);

    @PutMapping(value = "connectPaciente/atualizar")
    Paciente atualizarPaciente(Paciente paciente);;

    @PutMapping(value = "connectToken/updateToken")
    Token updateToken( Token token);
}

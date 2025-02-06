package com.h_salvacao.ms_token.feigClients;

import com.h_salvacao.ms_token.model.Paciente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "ms-connect/paciente", url ="http://localhost:8001/connectPaciente")
public interface PacienteFeignClient {

    @GetMapping(value = "/getCpf/{cpf}")
    ResponseEntity<Paciente> getPaciente(@PathVariable("cpf") String cpf);
}

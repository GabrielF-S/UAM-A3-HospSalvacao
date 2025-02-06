package com.h_salvacao.ms_guiche.feignCliente;

import com.h_salvacao.ms_guiche.model.Paciente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "ms-connect/connectPaciente", url ="http://localhost:8001/connectPaciente")
public interface PacienteFeignClient {


    @PostMapping(value = "/salvar")
    Paciente salvarPaciente(@RequestBody Paciente paciente);

    @PutMapping(value = "/atualizar")
    Paciente atualizarPaciente(Paciente paciente);;



}

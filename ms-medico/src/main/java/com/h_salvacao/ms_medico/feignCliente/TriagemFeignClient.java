package com.h_salvacao.ms_medico.feignCliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ms-triagem", url = "http://localhost:8082/api/triagem")
public interface TriagemFeignClient {

    @GetMapping("/chamar-medico")
    ResponseEntity<Token> chamarMedico();
}

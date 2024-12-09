package com.h_salvacao.ms_medico.feignCliente;

import com.h_salvacao.ms_medico.model.Ficha;
import com.h_salvacao.ms_medico.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "ms-connect", url ="http://localhost:8001")
public interface MedicoFeignClient {

    @GetMapping(value = "connectToken/getToken/{tokenNumber}")
    ResponseEntity<Token> getToken(@PathVariable("tokenNumber")  String tokenNumber);

    @GetMapping(value = "connectFicha/get/{tokenId}")
    Ficha getFicha(@PathVariable("tokenId") Long tokenId);

    @PostMapping(value = "connectFicha/update")
    Ficha atulizarFicha(Ficha ficha);
}

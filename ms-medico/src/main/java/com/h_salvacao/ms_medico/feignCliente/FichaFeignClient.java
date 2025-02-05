package com.h_salvacao.ms_medico.feignCliente;

import com.h_salvacao.ms_medico.model.Ficha;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "ms-connect/connectFicha", url ="http://localhost:8001")
public interface FichaFeignClient {

    @GetMapping(value = "/get/{tokenId}")
    Ficha getFicha(@PathVariable("tokenId") Long tokenId);


    @PostMapping(value = "/update")
    Ficha atulizarFicha(Ficha ficha);


}

package com.h_salvacao.ms_triagem.feignCliente;

import com.h_salvacao.ms_triagem.model.Ficha;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Component
@FeignClient(name = "ms-connect/connectFicha", url ="http://localhost:8001")
public interface FichaFeingClient {

    @PostMapping(value = "/save")
    Ficha saveFicha(@RequestBody Ficha ficha);
}

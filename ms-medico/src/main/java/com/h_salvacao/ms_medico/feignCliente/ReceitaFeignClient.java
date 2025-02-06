package com.h_salvacao.ms_medico.feignCliente;

import com.h_salvacao.ms_medico.model.Receita;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "ms-connect/connectReceita", url ="http://localhost:8001/connectReceita")
public interface ReceitaFeignClient {
    @PostMapping(value = "connectReceita/salvar")
    Receita salvarReceita(@RequestBody Receita receita);
}

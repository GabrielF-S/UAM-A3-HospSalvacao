package com.h_salvacao.ms_triagem.feignCliente;

import com.h_salvacao.ms_triagem.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "ms-atendimento", url ="http://localhost:8040")
public interface AtendimentoFeingClient {


    @PostMapping(value = "atendimento/enviarAtendimento")
    Token enviarAtendimetno(@RequestBody Token token);

}

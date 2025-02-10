package com.h_salvacao.ms_atendimento.feignClient;

import com.h_salvacao.ms_atendimento.model.TempoAtendimento;
import com.h_salvacao.ms_atendimento.util.PeriodoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(name = "ms-connect/connectAtendimento", url ="http://localhost:8001/connectAtendimento")
public interface TempoAtendimentoFeignClient {

    @GetMapping(value = "/getAtendimento")
    ResponseEntity<List<TempoAtendimento>> getAllAtendimentoDoDia();

    @GetMapping(value = "/getAtendimento/porPeriodo")
    ResponseEntity<List<TempoAtendimento>> getAllAtendimentoPorPeriodo(PeriodoRequest periodo);
}

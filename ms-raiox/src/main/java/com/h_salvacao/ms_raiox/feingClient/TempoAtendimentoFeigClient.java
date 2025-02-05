package com.h_salvacao.ms_raiox.feingClient;


import com.h_salvacao.ms_raiox.model.TempoAtendimento;
import com.h_salvacao.ms_raiox.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "ms-connect/connectAtendimento", url ="http://localhost:8001")
public interface TempoAtendimentoFeigClient {
    @GetMapping(value = "connectToken/getToken/{tokenNumber}")
    ResponseEntity<Token> getToken(@PathVariable("tokenNumber")  String tokenNumber);



    @GetMapping(value = "/getAtendimento/{numToken}")
    TempoAtendimento getTempoAtendimento(@PathVariable("numToken")  String numToken);

    @PutMapping(value = "/updateAtendimento")
    void updateAtendimento(@RequestBody TempoAtendimento atendimento);


}

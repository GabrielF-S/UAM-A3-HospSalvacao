package com.h_salvacao.ms_triagem.feignCliente;

import com.h_salvacao.ms_triagem.model.Ficha;
import com.h_salvacao.ms_triagem.model.TempoAtendimento;
import com.h_salvacao.ms_triagem.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(name = "ms-connect", url ="http://localhost:8001")
public interface TriagemFeignClient {

    @GetMapping(value = "connectToken/get/{id}")
    ResponseEntity<Token> getToken(Long id);

    @GetMapping(value ="connectToken/get")
    ResponseEntity<List<Token>> getAllTokens();

    @GetMapping(value = "connectToken/getToken/{tokenNumber}")
    ResponseEntity<Token> getToken(@PathVariable("tokenNumber")  String tokenNumber);

    @PostMapping(value = "/connectFicha/save")
    Ficha sendFicha(@RequestBody Ficha ficha);

    @PutMapping(value ="connectToken/updateToken")
    Token updateToken(@RequestBody  Token token);

    @GetMapping(value = "connectAtendimento/getAtendimento/{numToken}")
    TempoAtendimento getTempoAtendimento(@PathVariable("numToken")  String numToken);

    @PutMapping(value = "connectAtendimento/updateAtendimento")
    void updateAtendimento(@RequestBody TempoAtendimento atendimento);
}

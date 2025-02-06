package com.h_salvacao.ms_atendimento.controller;

import com.h_salvacao.ms_atendimento.util.Stack;
import com.h_salvacao.ms_atendimento.model.Token;
import org.springframework.web.bind.annotation.GetMapping;

public interface TokenController {

    @GetMapping
    Stack<Token> getStack();

    @GetMapping(value = "getTamanho")
    Integer getTamanho();


}

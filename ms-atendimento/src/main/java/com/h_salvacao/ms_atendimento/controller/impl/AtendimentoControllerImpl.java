package com.h_salvacao.ms_atendimento.controller.impl;

import com.h_salvacao.ms_atendimento.controller.AtendimentoController;
import com.h_salvacao.ms_atendimento.model.Stack;
import com.h_salvacao.ms_atendimento.model.Token;
import com.h_salvacao.ms_atendimento.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "atendimento")
public class AtendimentoControllerImpl implements AtendimentoController{

    @Autowired
    AtendimentoService atendimentoService;

    @Override
    public Stack<Token> getStack() {
        return atendimentoService.getStack();
    }
}

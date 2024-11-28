package com.h_salvacao.ms_guiche.service.impl;

import com.h_salvacao.ms_guiche.feignCliente.GuicheFeignCliente;
import com.h_salvacao.ms_guiche.model.AtendimentoStatus;
import com.h_salvacao.ms_guiche.model.TipoAtendimento;
import com.h_salvacao.ms_guiche.model.Token;
import com.h_salvacao.ms_guiche.model.Triagem;
import com.h_salvacao.ms_guiche.service.GuicheService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class GuicheServiceImpl implements GuicheService {
    @Autowired
    Triagem triagem;

    private final GuicheFeignCliente guicheFeignCliente;

    @Override
    public void adicionarFila(Token token) {
        triagem.adicionarFila(token);

    }

    @Override
    public Integer pegarTotal(){
        return  triagem.getFila().size();
    }

    @Override
    public Token chamarProximo() {
        String numToken = triagem.getFila().dequeue().getNumToken();

        Token token = guicheFeignCliente.getToken(numToken).getBody();
        if (token != null && token.getStatus() == AtendimentoStatus.AGUARD_GUICHE){
            return token;
        }
        return new Token(0L,"0", LocalDateTime.now(), null, AtendimentoStatus.DESCONHECIDO, TipoAtendimento.DESCONHECIDO);

    }
}

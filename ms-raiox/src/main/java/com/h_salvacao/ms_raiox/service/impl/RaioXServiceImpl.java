package com.h_salvacao.ms_raiox.service.impl;

import com.h_salvacao.ms_raiox.feingClient.raioXFeingClient;
import com.h_salvacao.ms_raiox.model.AtendimentoStatus;
import com.h_salvacao.ms_raiox.model.Encaminhamento;
import com.h_salvacao.ms_raiox.model.Token;
import com.h_salvacao.ms_raiox.model.Triagem;
import com.h_salvacao.ms_raiox.service.RaioXService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RaioXServiceImpl implements RaioXService {
    @Autowired
    Triagem triagem;

    private final raioXFeingClient feingClient;

    @Override
    public void adicionarFila(Encaminhamento encaminhamento) {
        triagem.adicionarFila(encaminhamento);

    }

    @Override
    public Integer getTotal() {
        return triagem.getFila().size();
    }

    @Override
    public Encaminhamento chamarProximo() {
        Encaminhamento encaminhamento = triagem.getFila().dequeue();
       String numToken = encaminhamento.getNumToken();
        Token token = feingClient.getToken(numToken).getBody();
        if (token != null && token.getStatus() == AtendimentoStatus.RAIOX){

            return  encaminhamento;
        }else {
            throw new RuntimeException("Token não localizado na base");
        }
    }

    @Override
    public void encaminharPaciente(Encaminhamento encaminhamento) {
        String numToken = encaminhamento.getNumToken();
        Token token = feingClient.getToken(numToken).getBody();
        if (token != null){
            //TODO
        }

    }
}

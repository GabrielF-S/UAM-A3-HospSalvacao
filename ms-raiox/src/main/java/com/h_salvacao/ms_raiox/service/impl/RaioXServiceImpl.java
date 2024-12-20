package com.h_salvacao.ms_raiox.service.impl;

import com.h_salvacao.ms_raiox.model.Encaminhamento;
import com.h_salvacao.ms_raiox.model.Triagem;
import com.h_salvacao.ms_raiox.service.RaioXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaioXServiceImpl implements RaioXService {
    @Autowired
    Triagem triagem;

    @Override
    public void adicionarFila(Encaminhamento encaminhamento) {
        triagem.adicionarFila(encaminhamento);

    }
}

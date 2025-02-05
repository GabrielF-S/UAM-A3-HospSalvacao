package com.h_salvacao.ms_raiox.service;

import com.h_salvacao.ms_raiox.model.Encaminhamento;
import org.springframework.stereotype.Service;

@Service
public interface EncaminhamentoService {
    void adicionarFila(Encaminhamento encaminhamento);

    Integer getTotal();

    Encaminhamento chamarProximo();

    void encaminharPaciente(Encaminhamento encaminhamento);
}

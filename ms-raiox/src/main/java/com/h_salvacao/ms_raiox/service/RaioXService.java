package com.h_salvacao.ms_raiox.service;

import com.h_salvacao.ms_raiox.model.Encaminhamento;

public interface RaioXService {
    void adicionarFila(Encaminhamento encaminhamento);

    Integer getTotal();

    Encaminhamento chamarProximo();

    void encaminharPaciente(Encaminhamento encaminhamento);
}

package com.h_salvacao.ms_medicacao.services;

import com.h_salvacao.ms_medicacao.model.Encaminhamento;
import com.h_salvacao.ms_medicacao.util.Queue;

public interface EncaminhamentoService {

    void adicionarFila(Encaminhamento encaminhamento);

    Integer getQtd();

    Encaminhamento getProximo();

    void encaminharPaciente(Encaminhamento encaminhamento);

    Queue<Encaminhamento> getLista();
}

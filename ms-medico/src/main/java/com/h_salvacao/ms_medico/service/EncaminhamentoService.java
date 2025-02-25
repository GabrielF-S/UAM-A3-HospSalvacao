package com.h_salvacao.ms_medico.service;

import com.h_salvacao.ms_medico.model.Encaminhamento;

public interface EncaminhamentoService {
    Encaminhamento saveEncaminhamento(Encaminhamento encaminhamento);

    Encaminhamento getEncaminhamento(String numToken);

    Encaminhamento encaminharPaciente(Encaminhamento encaminhamento);
}

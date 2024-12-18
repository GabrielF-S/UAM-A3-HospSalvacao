package com.h_salvacao.ms_medico.service;

import com.h_salvacao.ms_medico.model.Encaminhamento;
import com.h_salvacao.ms_medico.model.Token;

public interface MedicoProducerSender {

    void sendoToRaioX(Encaminhamento encaminhamento);

    void sendoToAtendimento(Token token);

    void sentoToMedicacaoERaioX(Encaminhamento encaminhamento);
}

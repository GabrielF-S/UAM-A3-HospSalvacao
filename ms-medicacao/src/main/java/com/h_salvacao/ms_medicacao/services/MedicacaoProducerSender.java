package com.h_salvacao.ms_medicacao.services;

import com.h_salvacao.ms_medicacao.model.Encaminhamento;
import com.h_salvacao.ms_medicacao.model.Token;
import com.h_salvacao.ms_medico.model.Encaminhamento;
import com.h_salvacao.ms_medico.model.Token;

public interface MedicacaoProducerSender {

    void sendoToRaioX(Encaminhamento encaminhamento);

    void sendoToAtendimento(Token token);

    void sentoToMedico(Token token);
}

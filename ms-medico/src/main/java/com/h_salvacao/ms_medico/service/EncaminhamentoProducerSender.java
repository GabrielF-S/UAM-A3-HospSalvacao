package com.h_salvacao.ms_medico.service;

import com.h_salvacao.ms_medico.model.Encaminhamento;
import com.h_salvacao.ms_medico.model.Token;

public interface EncaminhamentoProducerSender {

    void sendoToRaioX(Encaminhamento encaminhamento);

    void sentoToMedicacaoERaioX(Encaminhamento encaminhamento);
}

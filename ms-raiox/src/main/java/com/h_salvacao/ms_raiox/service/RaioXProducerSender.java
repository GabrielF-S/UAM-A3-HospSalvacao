package com.h_salvacao.ms_raiox.service;

import com.h_salvacao.ms_raiox.model.Encaminhamento;
import com.h_salvacao.ms_raiox.model.Token;

public interface RaioXProducerSender {

    void senToMedico(Token token);
}

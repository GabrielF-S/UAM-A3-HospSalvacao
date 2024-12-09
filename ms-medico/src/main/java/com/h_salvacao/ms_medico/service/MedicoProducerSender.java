package com.h_salvacao.ms_medico.service;

import com.h_salvacao.ms_medico.model.Token;

public interface MedicoProducerSender {

    void sendoToAtendimento(Token token);
}

package com.h_salvacao.ms_guiche.service;

import com.h_salvacao.ms_guiche.model.Token;

public interface TokenProducerSender {
    void send(Token token);

    void sendoToAtendimento(Token token);
}

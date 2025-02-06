package com.h_salvacao.ms_triagem.service;

import com.h_salvacao.ms_triagem.model.Token;

public interface TokenProducerSender {

     void sendToken(Token token);

     void sendoToAtendimento(Token token);
}

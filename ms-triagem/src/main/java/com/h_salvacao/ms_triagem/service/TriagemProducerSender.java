package com.h_salvacao.ms_triagem.service;

import com.h_salvacao.ms_triagem.model.Ficha;
import com.h_salvacao.ms_triagem.model.Token;

public interface TriagemProducerSender {

    public void sendFicha(Token token);
}

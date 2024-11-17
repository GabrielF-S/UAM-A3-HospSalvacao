package com.h_salvacao.ms_triagem.listener.impl;


import com.h_salvacao.ms_triagem.entity.Token;
import com.h_salvacao.ms_triagem.listener.TokenConsumerListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class TokenConsumerListenerImpl implements TokenConsumerListener {
    @Override
    public void listener(ConsumerRecord<String, Token> record) {

    }
}

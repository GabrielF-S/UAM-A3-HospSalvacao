package com.h_salvacao.ms_triagem.listener;

import com.h_salvacao.ms_triagem.custom.TokenConsumerCustomListener;
import com.h_salvacao.ms_triagem.entity.Token;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface TokenConsumerListener {

    @TokenConsumerCustomListener(groupId = "group-1")
    public void listener(ConsumerRecord<String, Token> record);
}

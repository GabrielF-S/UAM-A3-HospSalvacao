package com.h_salvacao.ms_atendimento.listener;

import com.h_salvacao.ms_atendimento.model.Token;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public interface TokenConsumerListener {

    @KafkaListener(topics = "atendimento-topic",containerFactory = "tokenContainerFactory")
    public void listener(ConsumerRecord<String, Token> record);

}

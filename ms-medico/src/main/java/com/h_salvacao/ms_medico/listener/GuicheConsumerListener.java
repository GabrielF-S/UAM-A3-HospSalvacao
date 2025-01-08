package com.h_salvacao.ms_medico.listener;

import com.h_salvacao.ms_medico.model.Token;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public interface GuicheConsumerListener {

    @KafkaListener(topics = "medico-topic", containerFactory = "tokenContainerFactory")
    public void listenerRegular(ConsumerRecord<String, Token> record);

    @KafkaListener(topics = "retorno-topic", containerFactory = "tokenContainerFactory")
    public void listenerReturn(ConsumerRecord<String, Token> record);
}

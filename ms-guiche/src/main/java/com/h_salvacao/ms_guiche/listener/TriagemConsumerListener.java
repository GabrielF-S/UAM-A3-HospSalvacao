package com.h_salvacao.ms_guiche.listener;

import com.h_salvacao.ms_guiche.model.Ficha;
import com.h_salvacao.ms_guiche.model.Token;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public interface TriagemConsumerListener {

    @KafkaListener(topics = "guiche-topic", containerFactory = "tokenContainerFactory")
    public void listener(ConsumerRecord<String, Token> record);

}

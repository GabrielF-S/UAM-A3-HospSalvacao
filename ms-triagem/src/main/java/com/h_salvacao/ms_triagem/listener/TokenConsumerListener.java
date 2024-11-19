package com.h_salvacao.ms_triagem.listener;

import com.h_salvacao.ms_triagem.entity.Token;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

public interface TokenConsumerListener {

    @KafkaListener(topics = "triagem-topic", containerFactory = "tokenContainerFactory")
    public void listener(ConsumerRecord<String, Token> record);
}

package com.h_salvacao.ms_triagem.listener;

import com.h_salvacao.ms_triagem.model.Token;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.protocol.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

public interface TokenConsumerListener {

    @KafkaListener(topics = "triagem-topic", containerFactory = "tokenContainerFactory")
    public void listener(ConsumerRecord<String, Token> record);

//    @KafkaListener(topics = "triagem-topic", containerFactory = "tokenContainerFactory")
//    public  void  listener2(ConsumerRecords<String,Token> records);


}

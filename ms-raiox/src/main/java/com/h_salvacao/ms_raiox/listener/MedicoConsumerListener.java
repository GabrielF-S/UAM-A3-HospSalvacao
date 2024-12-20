package com.h_salvacao.ms_raiox.listener;

import com.h_salvacao.ms_raiox.model.Encaminhamento;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public interface MedicoConsumerListener {

    @KafkaListener(topics = "raiox-topic", containerFactory = "tokenContainerFactory")
    public void listener(ConsumerRecord<String, Encaminhamento> record);
}

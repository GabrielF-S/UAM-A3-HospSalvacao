package com.h_salvacao.ms_medicacao.listener;

import com.h_salvacao.ms_medicacao.model.Encaminhamento;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public interface EncaminhamentoConsumerListener {

    @KafkaListener(topics = "intravenosa-topic", containerFactory = "tokenContainerFactory")
    public void listener(ConsumerRecord<String, Encaminhamento> record);
}

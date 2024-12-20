package com.h_salvacao.ms_raiox.configs;


import com.h_salvacao.ms_raiox.model.Encaminhamento;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

public interface RaioXConsumerConfig {

    @Bean
    public ConsumerFactory<String, Encaminhamento> consumerFactory();

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Encaminhamento > tokenContainerFactory(ConsumerFactory<String, Encaminhamento>  consumerFactory);

}

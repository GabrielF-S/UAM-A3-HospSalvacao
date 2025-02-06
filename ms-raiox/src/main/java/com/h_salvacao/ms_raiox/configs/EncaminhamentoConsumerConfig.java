package com.h_salvacao.ms_raiox.configs;


import com.h_salvacao.ms_raiox.model.Encaminhamento;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

public interface EncaminhamentoConsumerConfig {

    @Bean
    ConsumerFactory<String, Encaminhamento> consumerFactory();

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, Encaminhamento > tokenContainerFactory(ConsumerFactory<String, Encaminhamento>  consumerFactory);

}

package com.h_salvacao.ms_guiche.config;

import com.h_salvacao.ms_guiche.model.Ficha;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public interface GuicheConsumerConfig {

    @Bean
    public ConsumerFactory<String, Ficha> consumerFactory();

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Ficha> tokenContainerFactory(ConsumerFactory<String, Ficha> consumerFactory);


}



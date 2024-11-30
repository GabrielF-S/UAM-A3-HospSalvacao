package com.h_salvacao.ms_guiche.config;

import com.h_salvacao.ms_guiche.model.Ficha;
import com.h_salvacao.ms_guiche.model.Token;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public interface GuicheConsumerConfig {

    @Bean
    public ConsumerFactory<String, Token> consumerFactory();

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Token> tokenContainerFactory(ConsumerFactory<String, Token> consumerFactory);


}



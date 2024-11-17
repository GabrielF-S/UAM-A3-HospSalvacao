package com.h_salvacao.ms_triagem.configs;

import com.h_salvacao.ms_triagem.entity.Token;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

public interface TriagemConsumerConfig {

    @Bean
    public ConsumerFactory<String, Token> consumerFactory();

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Token > tokenContainerFactory(ConsumerFactory<String, Token>  consumerFactory);
}

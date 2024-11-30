package com.h_salvacao.ms_atendimento.config;

import com.h_salvacao.ms_atendimento.model.Token;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

public interface AtendimentoConsumerConfig {
    @Bean
    public ConsumerFactory<String, Token> consumerFactory();

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Token > tokenContainerFactory(ConsumerFactory<String, Token>  consumerFactory);
    @Bean
    public KafkaListenerContainerFactory<?> batchFactory();

}

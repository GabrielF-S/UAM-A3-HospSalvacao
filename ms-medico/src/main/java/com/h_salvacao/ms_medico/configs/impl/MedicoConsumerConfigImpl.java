package com.h_salvacao.ms_medico.configs.impl;

import com.h_salvacao.ms_medico.configs.MedicoConsumerConfig;
import com.h_salvacao.ms_medico.model.Token;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
@EnableKafka
@Configuration
@RequiredArgsConstructor
public class MedicoConsumerConfigImpl implements MedicoConsumerConfig {
    private final KafkaProperties kafkaProperties;
    @Override
    @Bean
    public ConsumerFactory<String, Token> consumerFactory() {
        var configs = new HashMap<String, Object>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "medico-topic");
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        configs.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class.getName());
        configs.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, JsonDeserializer.class.getName());
        configs.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        configs.put(JsonDeserializer.VALUE_DEFAULT_TYPE, "com.h_salvacao.ms_medico.model.Token");
        return new DefaultKafkaConsumerFactory<>(configs);
    }

    @Override
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Token> tokenContainerFactory(ConsumerFactory<String, Token> consumerFactory) {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, Token>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }


}

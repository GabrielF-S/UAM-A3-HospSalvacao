package com.h_salvacao.ms_triagem.configs.impl;

import com.h_salvacao.ms_triagem.configs.TriagemConsumerConfig;
import com.h_salvacao.ms_triagem.entity.Token;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;

@Configuration
@RequiredArgsConstructor
public class TriagemConsumerConfigImpl implements TriagemConsumerConfig {

    private final KafkaProperties kafkaProperties;


    @Override
    public ConsumerFactory<String, Token> consumerFactory() {
        var configs = new HashMap<String, Object>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
        configs.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        configs.put(JsonDeserializer.VALUE_DEFAULT_TYPE, Token.class.getName());
        return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new JsonDeserializer<>(Token.class));
    }

    @Override
    public ConcurrentKafkaListenerContainerFactory<String, Token> tokenContainerFactory(
            ConsumerFactory<String, Token> consumerFactory
    ) {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, Token>();
        factory.setConsumerFactory(consumerFactory);
        return  factory;

    }
}

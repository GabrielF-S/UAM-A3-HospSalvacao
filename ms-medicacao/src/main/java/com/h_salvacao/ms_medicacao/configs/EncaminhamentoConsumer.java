package com.h_salvacao.ms_medicacao.configs;

import com.h_salvacao.ms_medicacao.model.Encaminhamento;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

public interface EncaminhamentoConsumer {
    @Bean
    ConsumerFactory<String, Encaminhamento> consumerFactory();

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, Encaminhamento > tokenContainerFactory(ConsumerFactory<String, Encaminhamento>  consumerFactory);

}

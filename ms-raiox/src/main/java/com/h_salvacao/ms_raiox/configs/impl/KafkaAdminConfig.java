package com.h_salvacao.ms_medico.configs.impl;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;

@RequiredArgsConstructor
@Configuration
public class KafkaAdminConfig {

    public final KafkaProperties kafkaProperties;

    public KafkaAdmin kafkaAdmin() {
        var configs = new HashMap<String, Object>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());

        return new KafkaAdmin(configs);
    }

    @Bean
    public KafkaAdmin.NewTopics topics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("atendimento-topic").partitions(1).replicas(1).build()
        );
    }

    @Bean
    public KafkaAdmin.NewTopics raioxTopic() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("raiox-topic").partitions(1).replicas(1).build()
        );
    }

    @Bean
    public KafkaAdmin.NewTopics intravenosaTopic() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("intravenosa-topic").partitions(1).replicas(1).build()
        );
    }

}

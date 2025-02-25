package com.h_salvacao.ms_medico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
@EnableFeignClients
public class MedicoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MedicoApplication.class, args);
    }
}

package com.h_salvacao.ms_atendimento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;
@EnableFeignClients
@EnableKafka
@SpringBootApplication
public class MsAtendimentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAtendimentoApplication.class, args);
	}

}

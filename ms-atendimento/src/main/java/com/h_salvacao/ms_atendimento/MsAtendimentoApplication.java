package com.h_salvacao.ms_atendimento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class MsAtendimentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAtendimentoApplication.class, args);
	}

}

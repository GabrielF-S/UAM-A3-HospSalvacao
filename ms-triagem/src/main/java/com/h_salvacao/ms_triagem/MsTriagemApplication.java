package com.h_salvacao.ms_triagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@EnableFeignClients
@SpringBootApplication
public class MsTriagemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTriagemApplication.class, args);
	}

}

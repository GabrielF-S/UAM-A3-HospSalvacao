package com.h_salvacao.ms_guiche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@EnableFeignClients
@SpringBootApplication
public class MsGuicheApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGuicheApplication.class, args);
	}

}

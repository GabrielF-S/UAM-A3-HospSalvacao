package com.h_salvacao.ms_raiox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
@EnableFeignClients
public class MsRaioxApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRaioxApplication.class, args);
	}

}

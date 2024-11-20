package com.h_salvacao.ms_token;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class MsTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTokenApplication.class, args);
	}

}



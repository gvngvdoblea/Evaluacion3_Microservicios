package com.proyecto.despacho_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class DespachoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DespachoServiceApplication.class, args);
	}

}

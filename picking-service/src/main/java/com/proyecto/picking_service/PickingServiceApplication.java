package com.proyecto.picking_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class PickingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PickingServiceApplication.class, args);
	}

}

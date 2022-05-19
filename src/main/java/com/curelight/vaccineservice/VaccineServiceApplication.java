package com.curelight.vaccineservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class VaccineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccineServiceApplication.class, args);
		// some code
	}

}

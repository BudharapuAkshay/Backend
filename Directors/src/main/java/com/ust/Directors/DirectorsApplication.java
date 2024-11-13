package com.ust.Directors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DirectorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DirectorsApplication.class, args);
	}

}

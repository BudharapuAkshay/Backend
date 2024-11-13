package com.ust.Artists;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ArtistsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtistsApplication.class, args);
	}

}

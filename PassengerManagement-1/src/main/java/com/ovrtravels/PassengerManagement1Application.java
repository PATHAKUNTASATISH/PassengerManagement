package com.ovrtravels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PassengerManagement1Application {

	public static void main(String[] args) {
		SpringApplication.run(PassengerManagement1Application.class, args);
	}
	 @Bean
	    public RestTemplate restTesmplate() {
	        return new RestTemplate();
	    }
}

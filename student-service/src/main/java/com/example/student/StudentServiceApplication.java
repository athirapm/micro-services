package com.example.student;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
@EnableFeignClients("com.example.student.feignclient")
public class StudentServiceApplication {
	@Value("${address.service.url}")
	private String addressServiceUrl;

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}
	// creating webclient bean for calling address service from student service
	@Bean
	public WebClient webClient() {
		WebClient webClient=WebClient.builder().baseUrl(addressServiceUrl).build();
		return webClient;
	}

}

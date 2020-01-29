package com.emre.springboot.RestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.emre.springboot"})
public class RestApiApplication {

	public static void main(String[] args) {
		//git push deneme
		SpringApplication.run(RestApiApplication.class, args);
	}

}

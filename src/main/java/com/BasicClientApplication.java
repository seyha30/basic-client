package com;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BasicClientApplication {

	public static void main(String[] args) {
		WebClient client = WebClient.builder()
				  .baseUrl("http://localhost:8080")
				  .defaultCookie("cookieKey", "cookieValue")
				  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
				  .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
				  .build();
		SpringApplication.run(BasicClientApplication.class, args);
	}

}

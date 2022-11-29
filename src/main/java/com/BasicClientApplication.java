package com;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class BasicClientApplication implements CommandLineRunner {
	
	WebClient.Builder builder = WebClient.builder();

	public static void main(String[] args) {
		SpringApplication.run(BasicClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		WebClient webClient = 
				WebClient
				.builder()
				.baseUrl("https://uatapicorporate.acledabank.com.kh/api/acleda/directDebit/getAccesstoken")
				.filter(ExchangeFilterFunctions.basicAuthentication("SambatFinance", "$!Sam$Fnc!$^123"))
				.build()
				;
		
		Map<String, String>  map  = new HashMap<>();
		WebClient client1 = WebClient.builder().defaultHeaders(header -> header.setBasicAuth("SambatFinance", "$!Sam$Fnc!$^123")).build();
	client1.post()
		.uri("https://uatapicorporate.acledabank.com.kh/api/acleda/directDebit/getAccesstoken")
		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		.body(Mono.just(map), Map.class)
		.retrieve();
		System.out.println(client1);
	}

}

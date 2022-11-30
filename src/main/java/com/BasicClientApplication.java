package com;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class BasicClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BasicClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String username = "SambatFinance";
		String password = "$!Sam$Fnc!$^123";
		String uri = "https://uatapicorporate.acledabank.com.kh/api/acleda/directDebit/getAccesstoken";

//		WebClient.Builder builder = WebClient.builder();
//
//		WebClient webClient = 
//				WebClient
//				.builder()
//				.baseUrl("https://uatapicorporate.acledabank.com.kh/api/acleda/directDebit/getAccesstoken")
//				.filter(ExchangeFilterFunctions.basicAuthentication("SambatFinance", "$!Sam$Fnc!$^123"))
//				.build()
//				;
//		
//	webClient.get()
//	        .uri("https://uatapicorporate.acledabank.com.kh/api/acleda/directDebit/getAccesstoken")
//	        .retrieve()
//	        .bodyToMono(String.class);
//		
//		System.out.println(webClient.get()
//		        .uri("https://uatapicorporate.acledabank.com.kh/api/acleda/directDebit/getAccesstoken")
//		        .retrieve()
//		        .bodyToMono(String.class)
//		        );
//		
//				Map<String, String>  map  = new HashMap<>();
//		WebClient client1 = WebClient.builder().defaultHeaders(header -> header.setBasicAuth("SambatFinance", "$!Sam$Fnc!$^123")).build();
//	client1.post()
//				.uri("https://uatapicorporate.acledabank.com.kh/api/acleda/directDebit/getAccesstoken")
//				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//				.body(Mono.just(map), Map.class)
//				.retrieve().bodyToMono(String.class);
//	
//		System.out.println(client1.get());
//		
//		

		WebClient client = WebClient.create();

		LinkedMultiValueMap<String, String> credentials = new LinkedMultiValueMap<>();

		credentials.add("username", username);
		credentials.add("password", password);

//		String response = client.post()
//		      .uri(uri)
//		      .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//		      .accept(MediaType.APPLICATION_JSON)
//		      .body(BodyInserters.fromFormData(credentials))
//		      .retrieve()
//		      .bodyToMono(String.class)
//		      .expand(expander->{ expander.concat("token")}, 0)
//		      ;
		String response = "<token>eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2Njk3NzU3NTUsImp0aSI6ImM3MjU5YmEzLTc1ZWUtNDAxZi05MTk5LTcxMmMyMzExZmI3ZiJ9.A4aCbHpIkOKurMfXfXFhXUiFz6lwwlMJ6hEJVQ2NQ9YKgSMs1WRA1D0GPD62kiXqFf6AzXo0Vs0ui4De8E0K0g</token>";
		int beginIndex = response.indexOf("<token>");
		int endIndex = response.indexOf("</token>");

		System.out.println(beginIndex);
		System.out.println(endIndex);
		System.out.println("Response == > " + response.substring(beginIndex + 7, endIndex));

	}

}

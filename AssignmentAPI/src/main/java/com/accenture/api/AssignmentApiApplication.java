package com.accenture.api;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;






@SpringBootApplication
public class AssignmentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApiApplication.class, args);
	}
	
	
//	@EventListener(ApplicationReadyEvent.class)
//	public void fetchPost() {
//		final String url ="https://api.data.gov.sg/v1/transport";
//		WebClient webClient = WebClient.builder()
//				   .baseUrl(url)
//				   .build();
//		Flux<Post> fluxPosts = webClient.get().uri("/carpark-availability").retrieve().bodyToFlux(Post.class);
//	}

}

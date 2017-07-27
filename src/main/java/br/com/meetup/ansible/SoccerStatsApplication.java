package br.com.meetup.ansible;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoccerStatsApplication {
	
	//CONNECT to h2-console as jdbc:h2:mem:testdb user:sa
	
	public static void main(String[] args) {
		SpringApplication.run(SoccerStatsApplication.class, args);
	}
	
}

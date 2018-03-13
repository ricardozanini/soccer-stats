package br.com.meetup.ansible;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SoccerStatsApplication extends SpringBootServletInitializer {

    // CONNECT to h2-console as jdbc:h2:mem:testdb user:sa

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SoccerStatsApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SoccerStatsApplication.class, args);
    }
}

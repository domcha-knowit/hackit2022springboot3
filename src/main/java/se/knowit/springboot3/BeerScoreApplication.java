package se.knowit.springboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BeerScoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeerScoreApplication.class, args);
    }

    @Bean
    public WebClient webClient () {
        return WebClient.builder().baseUrl("https://api.punkapi.com").build();
    }
}

package se.knowit.springboot3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import se.knowit.springboot3.model.PunkModel;

@Service
public class PunkService {

    private final WebClient webClient;

    @Autowired
    public PunkService(WebClient webClient) {
        this.webClient = webClient;
    }

    public PunkModel getBeerDescription(String beerName) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/v2/beers")
                        .queryParam("beer_name", beerName).build())
                .retrieve().bodyToMono(PunkModel.class).block();
    }
}

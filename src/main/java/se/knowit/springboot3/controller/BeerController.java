package se.knowit.springboot3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.knowit.springboot3.model.Beer;
import se.knowit.springboot3.repository.BeerScoreRepository;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class BeerController {

    @Autowired
    private BeerScoreRepository beerScoreRepository;

    @RequestMapping(value = "beers", method = RequestMethod.GET)
    public List<Beer> list() {
        return beerScoreRepository.findAll();
    }

    @RequestMapping(value = "beer", method = RequestMethod.POST)
    public String postBeer() {
        return "Skål";
    }
}

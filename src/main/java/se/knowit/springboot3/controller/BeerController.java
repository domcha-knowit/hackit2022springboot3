package se.knowit.springboot3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "beers/{id}")
    public Beer get(@PathVariable Long id) {
        return beerScoreRepository.findById(id).orElse(null);
    }

    @DeleteMapping(value = "beers/{id}")
    public Beer delete(@PathVariable Long id) {
        Beer deletedBeer = beerScoreRepository.findById(id).orElse(null);
        if (deletedBeer == null) {
            return null;
        }
        beerScoreRepository.delete(deletedBeer);
        return deletedBeer;
    }

    @PutMapping(value = "beers/{id}")
    public Beer update(@PathVariable Long id, @RequestBody Beer beer) {
        Beer existingBeer = beerScoreRepository.findById(id).orElse(null);
        assert existingBeer != null;
        return beerScoreRepository.saveAndFlush(beer);
    }

    @PostMapping(value = "beers")
    public Beer postBeer(@RequestBody Beer beer) {
        return beerScoreRepository.saveAndFlush(beer);
    }
}
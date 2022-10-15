package se.knowit.springboot3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.knowit.springboot3.model.BeerModel;
import se.knowit.springboot3.model.PunkModel;
import se.knowit.springboot3.repository.BeerScoreRepository;
import se.knowit.springboot3.service.PunkService;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class BeerController {

    @Autowired
    private BeerScoreRepository beerScoreRepository;

    @Autowired
    private PunkService punkService;

    @GetMapping(value = "beers")
    public List<BeerModel> list() {
        return beerScoreRepository.findAll();
    }

    @GetMapping(value = "beers/{id}")
    public BeerModel get(@PathVariable String id) {
        return beerScoreRepository.findById(id).orElse(null);
    }

    @DeleteMapping(value = "beers/{id}")
    public BeerModel delete(@PathVariable String id) {
        BeerModel deletedBeer = beerScoreRepository.findById(id).orElse(null);
        if (deletedBeer == null) {
            return null;
        }
        beerScoreRepository.delete(deletedBeer);
        return deletedBeer;
    }

    @PutMapping(value = "beers/{id}")
    public BeerModel update(@PathVariable String id, @RequestBody BeerModel beer) {
        BeerModel existingBeer = beerScoreRepository.findById(id).orElse(null);
        assert existingBeer != null;
        return beerScoreRepository.saveAndFlush(beer);
    }

    @PostMapping(value = "beers")
    public BeerModel postBeer(@RequestBody BeerModel beer) {
        String beerName = beer.getName();
        PunkModel punkModel = punkService.getBeerDescription(beerName);

        BeerModel updatedBeer = BeerModel.builder()
                .name(beerName)
                .description(punkModel.description())
                .score(beer.getScore())
                .build();

        return beerScoreRepository.saveAndFlush(updatedBeer);
    }
}
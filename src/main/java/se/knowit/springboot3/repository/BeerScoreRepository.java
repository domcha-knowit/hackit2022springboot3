package se.knowit.springboot3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.knowit.springboot3.model.Beer;

public interface BeerScoreRepository extends JpaRepository<Beer, Long> {
}

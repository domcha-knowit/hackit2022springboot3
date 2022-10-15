package se.knowit.springboot3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.knowit.springboot3.model.BeerModel;

import java.util.Optional;

public interface BeerScoreRepository extends JpaRepository<BeerModel, Long> {

    Optional<BeerModel> findById(String id);
}

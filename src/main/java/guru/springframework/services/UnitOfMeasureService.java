package guru.springframework.services;

import guru.springframework.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureService {
    Iterable<UnitOfMeasure> findAll();
    Optional<UnitOfMeasure> findByDescription(String description);
    UnitOfMeasure save(UnitOfMeasure unitOfMeasure);
}

package ru.misha.repository;

import org.springframework.data.repository.CrudRepository;
import ru.misha.model.Street;

public interface StreetRepository extends CrudRepository<Street, Long> {
}

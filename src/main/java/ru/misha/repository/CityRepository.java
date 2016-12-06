package ru.misha.repository;

import org.springframework.data.repository.CrudRepository;
import ru.misha.model.City;

public interface CityRepository extends CrudRepository<City, Long> {

    City findByName(String name);
}

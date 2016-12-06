package ru.misha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.misha.model.City;
import ru.misha.repository.CityRepository;

import java.util.List;

@Service
public class CityService implements Services<City>{

    @Autowired
    CityRepository cityRepository;


    @Override
    public List<City> findAll() {
        return (List<City>) cityRepository.findAll();
    }

    @Override
    public void saveOrUpdate(City city) {
        cityRepository.save(city);
    }

    @Override
    public void delete(Long id) {
        cityRepository.delete(id);
    }

    public City findByName(String name) {
        return cityRepository.findByName(name);
    }
}

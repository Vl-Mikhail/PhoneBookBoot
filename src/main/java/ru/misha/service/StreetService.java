package ru.misha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.misha.model.Street;
import ru.misha.repository.StreetRepository;

import java.util.List;

@Service
public class StreetService implements Services<Street>{

    @Autowired
    StreetRepository streetRepository;

    @Override
    public List<Street> findAll() {
        return (List<Street>) streetRepository.findAll();
    }

    @Override
    public void saveOrUpdate(Street street) {
        streetRepository.save(street);
    }

    @Override
    public void delete(Long id) {
        streetRepository.delete(id);
    }
}

package ru.misha.repository;


import org.springframework.data.repository.CrudRepository;
import ru.misha.model.Client;


public interface ClientRepository extends CrudRepository<Client, Long> {


}

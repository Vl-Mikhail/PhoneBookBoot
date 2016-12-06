package ru.misha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.misha.model.Client;
import ru.misha.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService implements Services<Client> {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public void saveOrUpdate(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.delete(id);
    }

}

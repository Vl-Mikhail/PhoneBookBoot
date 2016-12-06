package ru.misha.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.misha.model.City;
import ru.misha.model.Client;
import ru.misha.model.Street;
import ru.misha.service.CityService;
import ru.misha.service.ClientService;
import ru.misha.service.StreetService;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private CityService cityService;
    @Autowired
    private StreetService streetService;

    @RequestMapping(value = "/api/clients", method = RequestMethod.GET)
    public List<Client> getClients() {
        return clientService.findAll();
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public void saveClient(@RequestBody Client client, @RequestBody City city,
                           @RequestBody Street street) {
        client.setCity(city);
        client.setStreet(street);

        cityService.saveOrUpdate(city);
        streetService.saveOrUpdate(street);
        clientService.saveOrUpdate(client);
    }


    @RequestMapping(value = "/api/clients/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteClient(@PathVariable("id") long id) {
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}

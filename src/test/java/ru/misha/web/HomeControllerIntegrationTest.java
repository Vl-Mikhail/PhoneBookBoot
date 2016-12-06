package ru.misha.web;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import ru.misha.PhoneBookApplication;
import ru.misha.model.Client;
import ru.misha.repository.ClientRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(PhoneBookApplication.class)
@WebIntegrationTest
public class HomeControllerIntegrationTest {

    RestTemplate restTemplate = new TestRestTemplate();

    @Autowired
    ClientRepository repository;

    @Before
    public void setUp() throws Exception {
        repository.save(new Client());
        repository.save(new Client());
    }

    @Test
    public void testGetClients() throws Exception {
        ResponseEntity<List<Client>> responseEntity = restTemplate.exchange("http://localhost:8080/api/clients",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Client>>() {
                });
        List<Client> body = responseEntity.getBody();
        assertThat(body.size(),is(2));

        //Получаем список наши id с контроллера
        List<Long> actualIds = body.stream()
                .map(client -> client.getId())
                .collect(toList());

        //Пороверит что в нашем списке есть два элемента в любом порядке
        assertThat(actualIds, containsInAnyOrder(1L, 2L) );
    }
}
package ru.misha.web;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.misha.model.Client;
import ru.misha.service.ClientService;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

    @Mock
    private ClientService clientService;

    @InjectMocks
    HomeController sut;

    @Test
    public void getClients() throws Exception {
        when(clientService.findAll()).thenReturn(ImmutableList.of());
        List<Client> clients = sut.getClients();
        verify(clientService).findAll();
    }
}
package com.banquito.corepasivos.client.service;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.client.repository.ClientRepository;
import com.banquito.corepasivos.client.model.Client;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAllClients() {
        return this.clientRepository.findAll();
    }
}

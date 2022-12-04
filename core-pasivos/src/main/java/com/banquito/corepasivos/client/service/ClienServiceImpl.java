package com.banquito.corepasivos.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.client.model.Client;
import com.banquito.corepasivos.client.repository.ClientRepository;

@Service
public class ClienServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> findAllClient(){
        return clientRepository.findAll();
    }
}
    

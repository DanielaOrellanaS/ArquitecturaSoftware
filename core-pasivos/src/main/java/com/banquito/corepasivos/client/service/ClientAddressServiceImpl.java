package com.banquito.corepasivos.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.client.model.ClientAddress;
import com.banquito.corepasivos.client.repository.ClientAddressRepository;

@Service
public class ClientAddressServiceImpl implements ClientAddressService {
    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Override
    public List<ClientAddress> getAllClientAddress(){
        return clientAddressRepository.findAll();
    }
}
package com.banquito.corepasivos.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.client.repository.ClientPhoneRepository;
import com.banquito.corepasivos.client.model.ClientPhone;

@Service
public class ClientPhonesServiceImpl implements ClientPhoneService{

    @Autowired
    private ClientPhoneRepository clientPhoneRepository;

    @Override
    public List<ClientPhone> getAllClientPhones() {
        return this.clientPhoneRepository.findAll();
    }

}

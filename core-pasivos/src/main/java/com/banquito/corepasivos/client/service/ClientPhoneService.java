package com.banquito.corepasivos.client.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.client.model.ClientPhone;
import com.banquito.corepasivos.client.repository.ClientPhoneRepository;

@Service
public class ClientPhoneService {
    private final ClientPhoneRepository clientPhoneRepository;

    public ClientPhoneService(ClientPhoneRepository clientPhoneRepository) {
        this.clientPhoneRepository = clientPhoneRepository;
    }

    @Transactional
    public ClientPhone save(ClientPhone clientPhone) {
        return this.clientPhoneRepository.save(clientPhone);
    }

    public List<ClientPhone> findAll() {
        List<ClientPhone> clientPhone = this.clientPhoneRepository.findAll();

        if (clientPhone.isEmpty())
            throw new RuntimeException("Client phones not found.");

        return clientPhone;
    }

    public List<ClientPhone> findByIdentificationClient(String identification) {
        List<ClientPhone> phonesByIdentificationClient = this.clientPhoneRepository.findByPkIdentificationEquals(identification);

        if (phonesByIdentificationClient.isEmpty())
            throw new RuntimeException("Phone of: " + identification + " not found.");

        return phonesByIdentificationClient;
    }

    @Transactional
    public ClientPhone updateByIdentificationClient(String identification, ClientPhone phoneClientDetails) {
        List<ClientPhone> phonesByIdentificationClient = this.clientPhoneRepository.findByPkIdentificationEquals(identification);

        if (phonesByIdentificationClient.isEmpty())
            throw new RuntimeException("Phone of: " + identification + " not found.");

        ClientPhone phoneClient = phonesByIdentificationClient.get(0);
        return this.clientPhoneRepository.save(phoneClientDetails);
    }

   
    @Transactional
    public ClientPhone deleteByIdentificationClient(String identification) {
        List<ClientPhone> phonesByIdentificationClient = this.clientPhoneRepository.findByPkIdentificationEquals(identification);

        if (phonesByIdentificationClient.isEmpty())
            throw new RuntimeException(
                    "Phone of: " + identification + " not found.");

        ClientPhone phoneClient = phonesByIdentificationClient.get(0);
        this.clientPhoneRepository.delete(phoneClient);
        return phoneClient;
    }

}

package com.banquito.corepasivos.client.service;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.client.repository.ClientRepository;
import com.banquito.corepasivos.client.model.Client;
import com.banquito.corepasivos.client.model.ClientPK;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findClient(ClientPK pk) {
        Optional<Client> client = this.clientRepository.findById(pk);
        if (client.isPresent())
            return client.get();
        else
            return null;
    }

    @Transactional
    public void createClient(Client client) {
        try {
            if (this.clientRepository.existsById(client.getPk())) {
                this.clientRepository.save(client);
            }
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @Transactional
    public void deleteClient(Client client) {
        Optional<Client> auxClient = this.clientRepository.findById(client.getPk());
        if (!auxClient.isPresent())
            throw new RuntimeException("Client not found");
        else
            try {
                this.clientRepository.delete(client);
            } catch (Exception e) {
                throw new RuntimeException("Error deleting client");
            }
    }

    @Transactional
    public void updateClient(ClientPK pk, Client client) {
        Optional<Client> auxClient = this.clientRepository.findById(pk);
        if (!auxClient.isPresent())
            throw new RuntimeException("Client not found");
        else
            try {
                this.clientRepository.save(client);
            } catch (Exception e) {
                throw new RuntimeException("Error updating client");
            }
    }

    @Transactional
    public void updateStatus(ClientPK pk) {
        Optional<Client> auxClients = this.clientRepository.findById(pk);
        if (!auxClients.isPresent()) {
            throw new RuntimeException("Client not found");
        } else {
            try {
                Client client = auxClients.get();
                if (client.getStatus().equals("ACT")) {
                    client.setStatus("INA");
                } else if (client.getStatus().equals("INA")) {
                    client.setStatus("ACT");
                }
                this.clientRepository.save(client);
            } catch (Exception e) {
                throw new RuntimeException("Error changing status");
            }
        }
    }
}
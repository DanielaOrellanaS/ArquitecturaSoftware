package com.banquito.corepasivos.client.service;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.client.repository.ClientRepository;
import com.banquito.corepasivos.client.model.Client;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAllClients() {
        return this.clientRepository.findAll();
    }

    public List<Client> findAllClientsByIdentification(String identification) {
        return this.clientRepository.findByPkIdentification(identification);
    }
    
    public boolean existsClientByIdentification(String identification) {
        return this.clientRepository.existsByPkIdentification(identification);
    }

    public List<Client> findAllClientsByStatus(String status) {
        return this.clientRepository.findByStatus(status);
    }

    @Transactional
    public void createClient(Client client) {
        this.clientRepository.save(client);
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
    public void updateClient(Client client) {
        Optional<Client> auxClient = this.clientRepository.findById(client.getPk());
        if (!auxClient.isPresent())
            throw new RuntimeException("Client not found");
        else
            try {
                this.clientRepository.save(client);
            } catch (Exception e) {
                throw new RuntimeException("Error updating client");
            }
    }

    // change status
    @Transactional
    public void updateStatus(Client client) {
        Optional<Client> auxClient = this.clientRepository.findById(client.getPk());
        if (!auxClient.isPresent()){
            throw new RuntimeException("Client not found");
        } else {
            try {
                if(client.getStatus().equals("ACT")) {
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
package com.banquito.corepasivos.client.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.corepasivos.client.model.ClientRelationship;
import com.banquito.corepasivos.client.repository.ClientRelationshipRepository;

@Service
public class ClientRelationshipService {

    private final ClientRelationshipRepository clientRelationshipRepository;

    public ClientRelationshipService(ClientRelationshipRepository clientRelationshipRepository) {
        this.clientRelationshipRepository = clientRelationshipRepository;
    }

    public List<ClientRelationship> searchAll() {
        return clientRelationshipRepository.findAll();
    }

    public List<ClientRelationship> searchTypeRelationship(String relationshipType) {
        return clientRelationshipRepository.findByRelationshiptype(relationshipType);
    }

    public ClientRelationship searchById(String identification) {
        List<ClientRelationship> clientRelationships = this.clientRelationshipRepository
                .findByIdentification(identification);
        if (clientRelationships.get(0) == null) {
            throw new RuntimeException("Data not found");
        }
        return (clientRelationships.isEmpty()) ? null : clientRelationships.get(0);
    }

    @Transactional
    public void createClientRelationship(ClientRelationship clientRelationship) {
        try {
            this.clientRelationshipRepository.save(clientRelationship);
        } catch (Exception e) {
            throw new RuntimeException("There is already a relationship created with these parameters.");
        }
    }

    @Transactional
    public void updateClientRelationship(ClientRelationship clientRelationship) {
        List<ClientRelationship> clientRelationships = this.clientRelationshipRepository
                .findByIdentification(clientRelationship.getIdentification());
        if (clientRelationships.isEmpty()) {
            throw new RuntimeException("The client does not exist.");
        } else {
            this.clientRelationshipRepository.save(clientRelationship);
        }
    }

    @Transactional
    public void deleteClientRelationshipIdentification(String identification) {
        List<ClientRelationship> clientRelationships = this.clientRelationshipRepository
                .findByIdentification(identification);
        if (clientRelationships.isEmpty()) {
            throw new RuntimeException("The client with this ID does not exist.");
        } else {
            this.clientRelationshipRepository.delete(clientRelationships.get(0));
        }
    }

    @Transactional
    public void deleteClientRelationshipCode(Integer codeRelationship) {
        List<ClientRelationship> clientRelationships = this.clientRelationshipRepository
                .findByCodeRelationship(codeRelationship);
        if (clientRelationships.isEmpty()) {
            throw new RuntimeException("The client with this code does not exist.");
        } else {
            this.clientRelationshipRepository.delete(clientRelationships.get(0));
        }
    }
}
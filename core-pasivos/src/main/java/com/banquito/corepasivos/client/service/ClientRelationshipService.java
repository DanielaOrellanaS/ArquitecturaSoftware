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

    public ClientRelationship searchAll() {
        List<ClientRelationship> clientRelationship = this.clientRelationshipRepository.findAll();
        return (clientRelationship.isEmpty()) ? null : clientRelationship.get(0);
    }

    public ClientRelationship searchTypeRelationship(String relationshipType) {
        List<ClientRelationship> clientRelationships = this.clientRelationshipRepository.findByRelationShipType(relationshipType);
        return (clientRelationships.isEmpty()) ? null : clientRelationships.get(0);
    }

    public ClientRelationship searchById(String identification) {
        List<ClientRelationship> clientRelationships = this.clientRelationshipRepository.findByIdentification(identification);
        return (clientRelationships.isEmpty()) ? null : clientRelationships.get(0);
    }

    @Transactional
    public void register(ClientRelationship clientRelationship) {

        List<ClientRelationship> clientRelationships = clientRelationshipRepository.findByIdentification(clientRelationship.getIdentification());
        if (clientRelationships.isEmpty()) {
            this.clientRelationshipRepository.save(clientRelationship);
        } else {
            throw new RuntimeException("El cliente ya existe");
        }
    }

    @Transactional
    public void update(ClientRelationship clientRelationship) {
        List<ClientRelationship> clientRelationships = this.clientRelationshipRepository.findByIdentification(clientRelationship.getIdentification());
        if(clientRelationships.isEmpty()) {
            throw new RuntimeException("El cliente no existe");
        } else {
            this.clientRelationshipRepository.save(clientRelationship);
        }
    }

    @Transactional
    public void delete(String identification) {
        List<ClientRelationship> clientRelationships = this.clientRelationshipRepository.findByIdentification(identification);
        if(clientRelationships.isEmpty()) {
            throw new RuntimeException("El cliente no existe");
        } else {
            this.clientRelationshipRepository.delete(clientRelationships.get(0));
        }
    }
}

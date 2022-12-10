package com.banquito.corepasivos.client.service;

import java.util.List;
import java.util.Optional;

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

    public List<ClientRelationship> findByClient(String id, String type) {
        try {
            List<ClientRelationship> clientRelationships = this.clientRelationshipRepository
                    .findByIdentificationAndIdentificationtype(id, type);
            if (clientRelationships.isEmpty()) {
                throw new RuntimeException("Data not found");
            }
            return clientRelationships;
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @Transactional
    public void createClientRelationship(ClientRelationship clientRelationship) {
        try {
            if (this.clientRelationshipRepository.existsById(clientRelationship.getCodeRelationship())) {
                throw new RuntimeException("There is already a relationship created with these parameters.");
            }
            this.clientRelationshipRepository.save(clientRelationship);
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @Transactional
    public void updateClientRelationship(Integer pk, ClientRelationship clientRelationship) {
        try {
            if (!this.clientRelationshipRepository.existsById(clientRelationship.getCodeRelationship())) {
                throw new RuntimeException("Not found");
            }
            this.clientRelationshipRepository.save(clientRelationship);
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @Transactional
    public void deleteClientRelationship(Integer id) {
        try {
            Optional<ClientRelationship> optional = this.clientRelationshipRepository.findById(id);
            if (optional.isPresent()) {
                ClientRelationship relationship = optional.get();
                this.clientRelationshipRepository.delete(relationship);
            } else {
                throw new RuntimeException("Not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @Transactional
    public void deleteByClient(String id, String type) {
        try {
            this.clientRelationshipRepository
                    .deleteByIdentificationAndIdentificationtype(id, type);
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }
}
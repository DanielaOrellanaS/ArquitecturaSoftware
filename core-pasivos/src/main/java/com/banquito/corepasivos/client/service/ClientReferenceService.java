package com.banquito.corepasivos.client.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.client.model.ClientReference;
import com.banquito.corepasivos.client.repository.ClientReferenceRepository;

@Service
public class ClientReferenceService {
    private final ClientReferenceRepository clientReferenceRepo;

    public ClientReferenceService(ClientReferenceRepository clientReferenceRepo) {
        this.clientReferenceRepo = clientReferenceRepo;
    }

    public List<ClientReference> findAllClientReferences(String id, String type) {
        try {
            List<ClientReference> references = this.clientReferenceRepo
                    .findByIdentificationAndIdentificationtype(id, type);
            return references;
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @Transactional
    public void createClientReference(ClientReference reference) {
        try {
            Optional<ClientReference> optional = this.clientReferenceRepo.findById(reference.getCodeReference());
            if (optional.isPresent()) {
                throw new RuntimeException("Cant insert that referece");
            }
            this.clientReferenceRepo.save(reference);
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @Transactional
    public void updateClientReference(Integer pk, ClientReference client) {
        try {
            Optional<ClientReference> optional = this.clientReferenceRepo.findById(pk);
            if (optional.isPresent()) {
                this.clientReferenceRepo.save(client);
            } else {
                throw new RuntimeException("Client reference not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @Transactional
    public void deleteClientReference(Integer pk) {
        try {
            Optional<ClientReference> optional = this.clientReferenceRepo.findById(pk);
            if (optional.isPresent()) {
                ClientReference reference = optional.get();
                this.clientReferenceRepo.delete(reference);
            } else {
                throw new RuntimeException("Client reference not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

}

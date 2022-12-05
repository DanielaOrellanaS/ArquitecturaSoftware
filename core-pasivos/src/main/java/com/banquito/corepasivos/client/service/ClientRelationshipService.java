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

    @Transactional
    public void registrar(ClientRelationship clientRelationship) {

        List<ClientRelationship> clientRelationships = clientRelationshipRepository.findByIdentification(clientRelationship.getIdentification());
        if (clientRelationships.isEmpty()) {
            this.clientRelationshipRepository.save(clientRelationship);
        } else {
            throw new RuntimeException("El cliente ya existe");
        }
    }

    public ClientRelationship buscarPorRelacion(Integer codeRelationship) {
        List<ClientRelationship> clientRelationships = this.clientRelationshipRepository.findByCodeRelationship(codeRelationship);
        return (clientRelationships.isEmpty()) ? null : clientRelationships.get(0);
    }

    public ClientRelationship buscarPorIdentificacion(String identification) {
        List<ClientRelationship> clientRelationships = this.clientRelationshipRepository.findByIdentification(identification);
        return (clientRelationships.isEmpty()) ? null : clientRelationships.get(0);
    }

    @Transactional
    public void modificar(ClientRelationship clientRelationship) {
        List<ClientRelationship> clientRelationships = this.clientRelationshipRepository.findByIdentification(clientRelationship.getIdentification());
        if(clientRelationships.isEmpty()) {
            throw new RuntimeException("El cliente no existe");
        } else {
            this.clientRelationshipRepository.save(clientRelationship);
        }
    }

    @Transactional
    public void eliminar(String identification) {
        List<ClientRelationship> clientRelationships = this.clientRelationshipRepository.findByIdentification(identification);
        if(clientRelationships.isEmpty()) {
            throw new RuntimeException("El cliente no existe");
        } else {
            this.clientRelationshipRepository.delete(clientRelationships.get(0));
        }
    }
}

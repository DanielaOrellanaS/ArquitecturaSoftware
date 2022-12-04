package com.banquito.corepasivos.client.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.client.model.ClientReference;
import com.banquito.corepasivos.client.repository.ClientReferenceRepository;

@Repository
public class ClientReferenceServiceImpl implements ClientReferenceService {

    @Autowired
    private ClientReferenceRepository clientReferenceRepository;

    @Override
    @Transactional
    public ClientReference createClientReference(ClientReference clientReference) {
        return null;
    }

    @Override
    public List<ClientReference> readAllClients() {
        return this.clientReferenceRepository.findAll();
    }

    @Override
    public List<ClientReference> readByClientIdentification(String identification) {
        return this.clientReferenceRepository.findByIdentification(identification);
    }

    @Override
    public List<ClientReference> readByClientIdentificationType(String identificationType) {
        return this.clientReferenceRepository.findByIdentificationtype(identificationType);
    }
}

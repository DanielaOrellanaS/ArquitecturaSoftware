package com.banquito.corepasivos.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

import com.banquito.corepasivos.client.model.ClientReference;
import com.banquito.corepasivos.client.model.ClientReferencePK;
import com.banquito.corepasivos.client.repository.ClientReferenceRepository;

@Repository
public class ClientReferenceServiceImpl implements ClientReferenceService {

    @Autowired
    private ClientReferenceRepository clientReferenceRepository;

    @Override
    public ClientReference createClientReference(ClientReference clientReference) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ClientReference> readAllClients() {
        return this.clientReferenceRepository.findAll();
    }

    @Override
    public ClientReference readByCode(Integer code) {
        return this.clientReferenceRepository.findByPkCode(code).get(0);
    }

    @Override
    public List<ClientReference> readByClientIdentification(String identification) {
        return this.clientReferenceRepository.findByPkIdentification(identification);
    }

    @Override
    public List<ClientReference> readByClientIdentificationType(String identificationType) {
        return this.clientReferenceRepository.findByPkIdentificationtype(identificationType);
    }

    @Override
    public ClientReference updateClientReference(ClientReference clientReference, ClientReferencePK clientReferencePK) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteClientReference(ClientReferencePK clientReferencePK) {
        // TODO Auto-generated method stub

    }

}

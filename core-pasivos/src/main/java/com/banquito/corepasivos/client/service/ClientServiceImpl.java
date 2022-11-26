package com.banquito.corepasivos.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.corepasivos.client.model.ClientReference;
import com.banquito.corepasivos.client.model.ClientReferencePK;

@Repository
public class ClientServiceImpl implements ClientReferenceService {

    @Autowired
    private ClientReference clientReference;

    @Override
    @Transactional
    public ClientReference createClientReference(ClientReference clientReference) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ClientReference> fetchClientReferences() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public ClientReference updateClientReference(ClientReference clientReference, ClientReferencePK clientReferencePK) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public void deleteClientReference(ClientReferencePK clientReferencePK) {
        // TODO Auto-generated method stub

    }

}

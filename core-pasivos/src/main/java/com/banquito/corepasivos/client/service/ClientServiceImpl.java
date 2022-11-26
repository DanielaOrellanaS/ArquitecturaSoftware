package com.banquito.corepasivos.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.client.model.ClientReference;

@Repository
public class ClientServiceImpl implements ClientReferenceService {

    @Autowired
    private ClientReference clientReference;

    @Override
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
    public ClientReference updaClientReference(ClientReference clientReference, Integer codeReference) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteClientReference(Integer codeReference) {
        // TODO Auto-generated method stub

    }

}

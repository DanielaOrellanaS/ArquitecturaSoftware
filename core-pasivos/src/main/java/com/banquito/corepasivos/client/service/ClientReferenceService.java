package com.banquito.corepasivos.client.service;

import java.util.List;

import com.banquito.corepasivos.client.model.ClientReference;

public interface ClientReferenceService {
    ClientReference createClientReference(ClientReference clientReference);

    List<ClientReference> fetchClientReferences();

    ClientReference updaClientReference(ClientReference clientReference, Integer codeReference);

    void deleteClientReference(Integer codeReference);
}

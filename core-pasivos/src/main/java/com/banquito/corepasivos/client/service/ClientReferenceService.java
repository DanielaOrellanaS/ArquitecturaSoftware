package com.banquito.corepasivos.client.service;

import java.util.List;

import com.banquito.corepasivos.client.model.ClientReference;

public interface ClientReferenceService {
    ClientReference createClientReference(ClientReference clientReference);

    List<ClientReference> readAllClients();
    List<ClientReference> readByClientIdentification(String identification);
    List<ClientReference> readByClientIdentificationType(String identificationType);
}

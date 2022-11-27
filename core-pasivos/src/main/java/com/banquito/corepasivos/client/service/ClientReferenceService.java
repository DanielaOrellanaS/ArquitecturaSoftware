package com.banquito.corepasivos.client.service;

import java.util.List;

import com.banquito.corepasivos.client.model.ClientReference;
import com.banquito.corepasivos.client.model.ClientReferencePK;

public interface ClientReferenceService {
    ClientReference createClientReference(ClientReference clientReference);

    List<ClientReference> readAllClients();
    ClientReference readByCode(Integer code);
    List<ClientReference> readByClientIdentification(String identification);
    List<ClientReference> readByClientIdentificationType(String identificationType);

    ClientReference updateClientReference(ClientReference clientReference, ClientReferencePK clientReferencePK);

    void deleteClientReference(ClientReferencePK clientReferencePK);
}

package com.banquito.corepasivos.client.service;

import java.util.List;

import com.banquito.corepasivos.client.model.ClientReference;
import com.banquito.corepasivos.client.model.ClientReferencePK;

public interface ClientReferenceService {
    ClientReference createClientReference(ClientReference clientReference);

    List<ClientReference> fetchClientReferences();

    ClientReference updateClientReference(ClientReference clientReference, ClientReferencePK clientReferencePK);

    void deleteClientReference(ClientReferencePK clientReferencePK);
}

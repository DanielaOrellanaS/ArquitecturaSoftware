package com.banquito.corepasivos.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.model.ClientReference;
import com.banquito.corepasivos.client.service.ClientReferenceService;

@RestController
@RequestMapping("/client/reference")
public class ClientReferenceController {
    @Autowired
    private ClientReferenceService clientReferenceService;

    @GetMapping
    public List<ClientReference> readClientReferences() {
        return this.clientReferenceService.readAllClients();
    }

    @GetMapping("/identification/{identification}")
    public List<ClientReference> readClientReferencesByIdentification(
            @PathVariable("identification") String identification) {
        return this.clientReferenceService.readByClientIdentification(identification);
    }

    @GetMapping("/identificationtype/{type}")
    public List<ClientReference> readClientReferencesByIdentificationType(@PathVariable("type") String type) {
        return this.clientReferenceService.readByClientIdentificationType(type);
    }

    @GetMapping("/code/{code}")
    public ClientReference readClientReferenceByCode(@PathVariable("code") Integer code) {
        return this.clientReferenceService.readByCode(code);
    }
}

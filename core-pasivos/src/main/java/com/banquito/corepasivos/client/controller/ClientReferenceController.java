package com.banquito.corepasivos.client.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.model.ClientReference;
import com.banquito.corepasivos.client.service.ClientReferenceService;

@RestController
@RequestMapping("/api/client-reference")
public class ClientReferenceController {
    private final ClientReferenceService clientReferenceService;

    public ClientReferenceController(ClientReferenceService clientReferenceService) {
        this.clientReferenceService = clientReferenceService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<ClientReference>> findReferences() {
        List<ClientReference> clientReference = this.clientReferenceService.findAllClientReferences();
        if (clientReference == null) {
            return ResponseEntity.notFound().build();
        } else
            return ResponseEntity.ok(clientReference);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ClientReference>> findReferences(
            @PathVariable("id") String id) {
        List<ClientReference> clientReference = this.clientReferenceService.findAllClientReference(id);
        if (clientReference == null) {
            return ResponseEntity.notFound().build();
        } else
            return ResponseEntity.ok(clientReference);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createClientReference(@RequestBody ClientReference clientRef) {
        try {
            this.clientReferenceService.saveClientReference(clientRef);
            return ResponseEntity.ok("Client reference created succesfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<String> updateClientReference(@RequestBody ClientReference clientRef) {
        try {
            this.clientReferenceService.updateClientReference(clientRef);
            return ResponseEntity.ok("Client reference updated succesfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{codeReference}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteClientReference(
            @PathVariable("codeReference") Integer codeReference) {
        try {
            this.clientReferenceService.deleteClientReference(codeReference);
            return ResponseEntity.ok("Client reference delete succesfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}

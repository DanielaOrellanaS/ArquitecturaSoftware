package com.banquito.corepasivos.client.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.model.ClientRelationship;
import com.banquito.corepasivos.client.service.ClientRelationshipService;

@RestController
@RequestMapping("/api/client-relationships")
public class ClientRelationshipController {

    private final ClientRelationshipService clientRelationshipService;

    public ClientRelationshipController(ClientRelationshipService clientRelationshipService) {
        this.clientRelationshipService = clientRelationshipService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<ClientRelationship>> getAll() {
        List<ClientRelationship> clientRelationship = this.clientRelationshipService.searchAll();
        if (clientRelationship != null) {
            return ResponseEntity.ok(clientRelationship);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/relation-type/{relationshipType}", method = RequestMethod.GET)
    public ResponseEntity<List<ClientRelationship>> searchTypeRelationship(
            @PathVariable("relationshipType") String relationshipType) {
        List<ClientRelationship> clientRelationship = this.clientRelationshipService
                .searchTypeRelationship(relationshipType);
        if (clientRelationship != null) {
            return ResponseEntity.ok(clientRelationship);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/identification/{identification}", method = RequestMethod.GET)
    public ResponseEntity<ClientRelationship> searchById(@PathVariable("identification") String identification) {
        ClientRelationship clientRelationship = this.clientRelationshipService.searchById(identification);
        if (clientRelationship != null) {
            return ResponseEntity.ok(clientRelationship);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createClientRelationship(@RequestBody ClientRelationship clientRelationship) {
        try {
            this.clientRelationshipService.createClientRelationship(clientRelationship);
            return ResponseEntity.ok("Client created successfully.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<String> updateClientRelationship(@RequestBody ClientRelationship clientRelationship) {
        try {
            this.clientRelationshipService.updateClientRelationship(clientRelationship);
            return ResponseEntity.ok("Client updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "delete-identification/{identification}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteClientRelationshipIdentification(
            @PathVariable("identification") String identification) {
        try {
            this.clientRelationshipService.deleteClientRelationshipIdentification(identification);
            return ResponseEntity.ok("Customer relationship successfully removed.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/delete-code/{codeRelationship}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteClientRelationshipCode(
            @PathVariable("codeRelationship") Integer codeRelationship) {
        try {
            this.clientRelationshipService.deleteClientRelationshipCode(codeRelationship);
            return ResponseEntity.ok("Customer relationship successfully removed.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}

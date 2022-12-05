package com.banquito.corepasivos.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.model.ClientRelationship;
import com.banquito.corepasivos.client.service.ClientRelationshipService;

@RestController
@RequestMapping("/api/clientrelationship")
public class ClientRelationshipController {

    private final ClientRelationshipService service;

    public ClientRelationshipController(ClientRelationshipService service) {
        this.service = service;
    }

    /*GET */
    @GetMapping(path= "/all")
    public ResponseEntity<ClientRelationship> getAll() {
        ClientRelationship clientRelationship = this.service.searchAll();
        if(clientRelationship != null) {
            return ResponseEntity.ok(clientRelationship);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/identification/{identification}")
    public ResponseEntity<ClientRelationship> searchById(@PathVariable("identification") String identification) {
        ClientRelationship clientRelationship = this.service.searchById(identification);
        if (clientRelationship != null)
        {
            return ResponseEntity.ok(clientRelationship);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/relationshiptype/{relationshipType}")
    public ResponseEntity<ClientRelationship> searchTypeRelationship(@PathVariable("relationshipType") String relationshipType) {
        ClientRelationship clientRelationship = this.service.searchTypeRelationship(relationshipType);
        if (clientRelationship != null)
        {
            return ResponseEntity.ok(clientRelationship);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

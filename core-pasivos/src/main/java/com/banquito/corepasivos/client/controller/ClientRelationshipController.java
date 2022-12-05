package com.banquito.corepasivos.client.controller;

import javax.websocket.server.PathParam;

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

    @GetMapping(path = "/identification/{identification}")
    public ResponseEntity<ClientRelationship> buscarPorIdentificacion(@PathVariable("identification") String identification) {
        ClientRelationship clientRelationship = this.service.buscarPorIdentificacion(identification);
        if (clientRelationship != null)
        {
            return ResponseEntity.ok(clientRelationship);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/code/{codeRelationship}")
    public ResponseEntity<ClientRelationship> buscarPorRelacion(@PathVariable("codeRelationship") Integer codeRelationship) {
        ClientRelationship clientRelationship = this.service.buscarPorRelacion(codeRelationship);
        if (clientRelationship != null)
        {
            return ResponseEntity.ok(clientRelationship);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

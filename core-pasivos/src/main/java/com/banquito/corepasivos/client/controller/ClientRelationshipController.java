package com.banquito.corepasivos.client.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.model.ClientRelationship;
import com.banquito.corepasivos.client.service.ClientRelationshipService;
import com.banquito.corepasivos.utils.DTO;

@RestController
@RequestMapping("/api/client-relationships")
public class ClientRelationshipController {

    private final ClientRelationshipService clientRelationshipService;

    public ClientRelationshipController(ClientRelationshipService clientRelationshipService) {
        this.clientRelationshipService = clientRelationshipService;
    }

    @RequestMapping(value = "/{id}/{type}", method = RequestMethod.GET)
    public ResponseEntity<DTO<List<ClientRelationship>>> searchTypeRelationship(
            @PathVariable("id") String id,
            @PathVariable("type") String type) {
        DTO<List<ClientRelationship>> response = new DTO<>();
        try {
            List<ClientRelationship> relationships = this.clientRelationshipService.findByClient(id,
                    type.toUpperCase());
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Data found");
            response.setData(relationships);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<DTO<ClientRelationship>> createClientRelationship(
            @RequestBody ClientRelationship clientRelationship) {
        DTO<ClientRelationship> response = new DTO<>();
        try {
            this.clientRelationshipService.createClientRelationship(clientRelationship);
            response.setStatus(HttpStatus.CREATED.value());
            response.setMessage("Data successfully created");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DTO<ClientRelationship>> updateClientRelationship(
            @PathVariable("id") Integer id,
            @RequestBody ClientRelationship clientRelationship) {
        DTO<ClientRelationship> response = new DTO<>();
        try {
            this.clientRelationshipService.updateClientRelationship(id, clientRelationship);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Data successfully updated");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DTO<ClientRelationship>> deleteClientRelationshipIdentification(
            @PathVariable("id") Integer id) {
        DTO<ClientRelationship> response = new DTO<>();
        try {
            this.clientRelationshipService.deleteClientRelationship(id);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Data successfully deleted");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @RequestMapping(value = "/{id}/{type}", method = RequestMethod.DELETE)
    public ResponseEntity<DTO<ClientRelationship>> deleteClientRelationshipCode(
            @PathVariable("id") String id,
            @PathVariable("type") String type) {
        DTO<ClientRelationship> response = new DTO<>();
        try {
            this.clientRelationshipService.deleteByClient(id, type.toUpperCase());
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Data successfully deleted");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}

package com.banquito.corepasivos.client.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.dto.request.RequestDtoClientRelationship;
import com.banquito.corepasivos.client.dto.response.ResponseDtoClientRelationship;
import com.banquito.corepasivos.client.mapper.ClientRelationshipMapper;
import com.banquito.corepasivos.client.model.ClientRelationship;
import com.banquito.corepasivos.client.service.ClientRelationshipService;

@RestController
@RequestMapping("/api/client-relationships")
public class ClientRelationshipController {

    private final ClientRelationshipService clientRelationshipService;

    public ClientRelationshipController(ClientRelationshipService clientRelationshipService) {
        this.clientRelationshipService = clientRelationshipService;
    }

    @RequestMapping(value = "/{id}/{type}", method = RequestMethod.GET)
    public ResponseEntity<List<ResponseDtoClientRelationship>> searchTypeRelationship(
            @PathVariable("id") String id,
            @PathVariable("type") String type) {
        try {
            List<ClientRelationship> relationships = this.clientRelationshipService.findByClient(id,
                    type.toUpperCase());
            List<ResponseDtoClientRelationship> dtos = relationships.stream()
                    .map(relation -> ClientRelationshipMapper.map(relation)).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(dtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createClientRelationship(
            @RequestBody RequestDtoClientRelationship dto) {
        try {
            ClientRelationship clientRelationship = ClientRelationshipMapper.map(dto);
            this.clientRelationshipService.createClientRelationship(clientRelationship);
            return ResponseEntity.status(HttpStatus.OK).body("Data successfully created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{codeRelationship}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateClientRelationship(
            @PathVariable("codeRelationship") Integer id,
            @RequestBody RequestDtoClientRelationship dto) {
        try {
            ClientRelationship clientRelationship = ClientRelationshipMapper.map(dto);
            this.clientRelationshipService.updateClientRelationship(id, clientRelationship);
            return ResponseEntity.status(HttpStatus.OK).body("Data successfully updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteClientRelationshipIdentification(
            @PathVariable("id") Integer id) {
        try {
            this.clientRelationshipService.deleteClientRelationship(id);
            return ResponseEntity.status(HttpStatus.OK).body("Data successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{id}/{type}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteClientRelationshipCode(
            @PathVariable("id") String id,
            @PathVariable("type") String type) {
        try {
            this.clientRelationshipService.deleteByClient(id, type.toUpperCase());
            return ResponseEntity.status(HttpStatus.OK).body("Data successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

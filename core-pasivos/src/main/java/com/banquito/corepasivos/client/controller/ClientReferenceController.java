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

import com.banquito.corepasivos.client.dto.request.RequestDtoClientReference;
import com.banquito.corepasivos.client.dto.response.ResponseDtoClientReference;
import com.banquito.corepasivos.client.mapper.ClientReferenceMapper;
import com.banquito.corepasivos.client.model.ClientReference;
import com.banquito.corepasivos.client.service.ClientReferenceService;

@RestController
@RequestMapping("/api/client-reference")
public class ClientReferenceController {
    private final ClientReferenceService clientReferenceService;

    public ClientReferenceController(ClientReferenceService clientReferenceService) {
        this.clientReferenceService = clientReferenceService;
    }

    @RequestMapping(value = "/{id}/{type}", method = RequestMethod.GET)
    public ResponseEntity<List<RequestDtoClientReference>> findReferences(
            @PathVariable("id") String id,
            @PathVariable("type") String type) {
        try {
            List<ClientReference> references = this.clientReferenceService.findAllClientReferences(id,
                    type.toUpperCase());
            List<RequestDtoClientReference> dtos = references.stream().map(reference -> ClientReferenceMapper.map(reference))
                    .collect(Collectors.toList());

            return ResponseEntity.status(HttpStatus.OK).body(dtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createClientReference(@RequestBody ResponseDtoClientReference dto) {
        try {
            ClientReference clientRef = ClientReferenceMapper.map(dto);
            this.clientReferenceService.createClientReference(clientRef);
            return ResponseEntity.status(HttpStatus.CREATED).body("Reference successfully created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateClientReference(
            @PathVariable("id") Integer id,
            @RequestBody ResponseDtoClientReference dto) {
        try {
            ClientReference clientRef = ClientReferenceMapper.map(dto);
            this.clientReferenceService.updateClientReference(id, clientRef);
            return ResponseEntity.status(HttpStatus.OK).body("Reference successfully updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteClientReference(
            @PathVariable("id") Integer id) {
        try {
            this.clientReferenceService.deleteClientReference(id);
            return ResponseEntity.status(HttpStatus.OK).body("Reference successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}

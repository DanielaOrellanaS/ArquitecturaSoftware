package com.banquito.corepasivos.client.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.model.ClientReference;
import com.banquito.corepasivos.client.service.ClientReferenceService;
import com.banquito.corepasivos.utils.DTO;

@RestController
@RequestMapping("/api/client-reference")
public class ClientReferenceController {
    private final ClientReferenceService clientReferenceService;

    public ClientReferenceController(ClientReferenceService clientReferenceService) {
        this.clientReferenceService = clientReferenceService;
    }

    @RequestMapping(value = "/{id}/{type}", method = RequestMethod.GET)
    public ResponseEntity<DTO<List<ClientReference>>> findReferences(
            @PathVariable("id") String id,
            @PathVariable("type") String type) {
        DTO<List<ClientReference>> response = new DTO<>();
        try {
            List<ClientReference> references = this.clientReferenceService.findAllClientReferences(id,
                    type.toUpperCase());
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Data found");
            response.setData(references);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<DTO<ClientReference>> createClientReference(@RequestBody ClientReference clientRef) {
        DTO<ClientReference> response = new DTO<>();
        try {
            this.clientReferenceService.createClientReference(clientRef);
            response.setStatus(HttpStatus.CREATED.value());
            response.setMessage("Reference successfully created");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DTO<ClientReference>> updateClientReference(
            @PathVariable("id") Integer id,
            @RequestBody ClientReference clientRef) {
        DTO<ClientReference> response = new DTO<>();
        try {
            this.clientReferenceService.updateClientReference(id, clientRef);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Reference successfully updated");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DTO<ClientReference>> deleteClientReference(
            @PathVariable("id") Integer id) {
        DTO<ClientReference> response = new DTO<>();
        try {
            this.clientReferenceService.deleteClientReference(id);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Reference successfully deleted");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}

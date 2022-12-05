package com.banquito.corepasivos.client.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.model.ClientReference;
import com.banquito.corepasivos.client.service.ClientReferenceService;

@RestController
@RequestMapping("/clients")
public class ClientReferenceController {
    private final ClientReferenceService clientReferenceService;

    public ClientReferenceController(ClientReferenceService clientReferenceService) {
        this.clientReferenceService = clientReferenceService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<ClientReference>> findReferences(
        @PathVariable("id") String id
    ){
        List<ClientReference> clientReference = this.clientReferenceService.findAllClientReference(id);
        if(clientReference == null){
            return ResponseEntity.notFound().build();
        }else return ResponseEntity.ok(clientReference);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> createClientReference(@RequestBody ClientReference clientRef) {
        try {
            this.clientReferenceService.saveClientReference(clientRef);
            return ResponseEntity.ok("Client reference created succesfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    /*JSON for post
    {
    "codeReference": null,
    "identificationtype": "RUC",
    "identification": "1720744944001",
    "name": "test4",
    "phone": "0995118125",
    "related": "tio"
    }   
     */

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> updateClientReference(@RequestBody ClientReference clientRef){
        try{
            this.clientReferenceService.updateClientReference(clientRef);
            return ResponseEntity.ok("Client reference updated succesfully");
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    /*JSON for put
    {
    "codeReference": ExistingId(1,2,3),
    "identificationtype": "RUC",
    "identification": "1720744944001",
    "name": "a change",
    "phone": "0995118125",
    "related": "tio"
    }
     */

    @DeleteMapping("/{codeReference}")
    public ResponseEntity<String> deleteClientReference(
        @PathVariable("codeReference") Integer codeReference
    ) {
        try {
            this.clientReferenceService.deleteClientReference(codeReference);
            return ResponseEntity.ok("Client reference delete succesfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}

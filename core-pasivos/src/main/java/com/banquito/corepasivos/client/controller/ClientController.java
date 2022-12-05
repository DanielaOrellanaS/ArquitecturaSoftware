package com.banquito.corepasivos.client.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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

import com.banquito.corepasivos.client.model.Client;
import com.banquito.corepasivos.client.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clients = this.clientService.findAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/identification/{identification}")
    public ResponseEntity<Client> findAllClientsByIdentification(@PathVariable("identification") String identification) {
        if (!this.clientService.existsClientByIdentification(identification)) {
            return new ResponseEntity(("Client not found"), HttpStatus.NOT_FOUND);
        }else {
            List<Client> clients = this.clientService.findAllClientsByIdentification(identification);
            return new ResponseEntity(clients, HttpStatus.OK);
        }
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
        public ResponseEntity<String> createClient(@RequestBody Client client) {
            if (this.clientService.existsClientByIdentification(client.getPk().getIdentification())) {
                return ResponseEntity.badRequest().body("Client already exists");
            }else {
                this.clientService.createClient(client);
                return ResponseEntity.ok("Client created");
            }
    }

    @DeleteMapping("/identification/{identification}")
        public ResponseEntity<String> deleteClientEntity(@RequestBody Client client) {
            if (!this.clientService.existsClientByIdentification(client.getPk().getIdentification())) {
                return ResponseEntity.badRequest().body("Client not found");
            } else {
                this.clientService.deleteClient(client);
                return ResponseEntity.ok("Client deleted");
            }
    }
    @PutMapping(consumes = {"application/json"})
        public ResponseEntity<String> updateClient(@RequestBody Client client) {
            if (!this.clientService.existsClientByIdentification(client.getPk().getIdentification())) {
                return ResponseEntity.badRequest().body("Client not found");
            } else {
                this.clientService.updateClient(client);
                return ResponseEntity.ok("Client updated successfully");
            }
    }
}



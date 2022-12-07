package com.banquito.corepasivos.client.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    // Get
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clients = this.clientService.findAllClients();
        return ResponseEntity.ok(clients);
    }

    @RequestMapping(value = "/identification/{identification}", method = RequestMethod.GET)
    public ResponseEntity<Client> findAllClientsByIdentification(
            @PathVariable("identification") String identification) {
        if (!this.clientService.existsClientByIdentification(identification)) {
            return ResponseEntity.notFound().build();
        } else {
            List<Client> clients = this.clientService.findAllClientsByIdentification(identification);
            return ResponseEntity.ok(clients.get(0));
        }
    }

    @RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> findAllClientsByStatus(@PathVariable("status") String status) {
        List<Client> clients = this.clientService.findAllClientsByStatus(status);
        if (clients != null) {
            return ResponseEntity.ok(clients);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // post
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createClient(@RequestBody Client client) {
        if (this.clientService.existsClientByIdentification(client.getPk().getIdentification())) {
            return ResponseEntity.badRequest().body("Client already exists");
        } else {
            this.clientService.createClient(client);
            return ResponseEntity.ok("Client created");
        }
    }

    // // delete

    // @DeleteMapping("/identification/{identification}")
    // public ResponseEntity<String> deleteClientEntity(@RequestBody Client client)
    // {
    // if
    // (!this.clientService.existsClientByIdentification(client.getPk().getIdentification()))
    // {
    // return ResponseEntity.badRequest().body("Client not found");
    // } else {
    // this.clientService.deleteClient(client);
    // return ResponseEntity.ok("Client deleted");
    // }
    // }

    // put
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<String> updateClient(@RequestBody Client client) {
        if (!this.clientService.existsClientByIdentification(client.getPk().getIdentification())) {
            return ResponseEntity.badRequest().body("Client not found");
        } else {
            this.clientService.updateClient(client);
            return ResponseEntity.ok("Client updated successfully");
        }
    }

    // change status
    @RequestMapping(value = "/{identification}", method = RequestMethod.DELETE)
    public ResponseEntity<String> updateStatus(@PathVariable("identification") String identification) {
        if (!this.clientService.existsClientByIdentification(identification)) {
            return ResponseEntity.badRequest().body("Client not found");
        } else {
            this.clientService.updateStatus(identification);
            return ResponseEntity.ok("Client status changed successfully");
        }
    }

}
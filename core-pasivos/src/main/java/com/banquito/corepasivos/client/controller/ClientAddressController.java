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

import com.banquito.corepasivos.client.model.ClientAddress;
import com.banquito.corepasivos.client.model.ClientAddressPK;
import com.banquito.corepasivos.client.service.ClientAddressService;

@RestController
@RequestMapping("/api/clientaddresses")
public class ClientAddressController {

    private final ClientAddressService clientAddressService;

    public ClientAddressController(ClientAddressService clientAddressService) {
        this.clientAddressService = clientAddressService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientAddress>> findAllClientAddresses() {
        List<ClientAddress> clientAddresses = this.clientAddressService.findAllClientAddresses();
        return ResponseEntity.ok(clientAddresses);
    }

    @GetMapping("/address/{client}")
    public ResponseEntity<List<ClientAddress>> findAllClientAddresses(@PathVariable("client") String client) {
        List<ClientAddress> clientAddresses = this.clientAddressService.findAllClientAddressesByIdentification(client);
        return ResponseEntity.ok(clientAddresses);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> createClientAddress(@RequestBody ClientAddress clientAddress) {
        try {
            this.clientAddressService.createClientAddress(clientAddress);
            return ResponseEntity.ok("Address successfully created");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping(consumes = { "application/json" })
    public ResponseEntity<String> updateClientAddress(
            @RequestBody ClientAddress clientAddress) {
        try {
            this.clientAddressService.updateClientAddress(clientAddress);
            return ResponseEntity.ok("Address successfully updated");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{identification}/{type}/{location}")
    public ResponseEntity<String> deleteClientEntity(
            @PathVariable("identification") String client,
            @PathVariable("type") String type,
            @PathVariable("location") Integer location) {
        try {
            ClientAddressPK pk = new ClientAddressPK();
            pk.setCodeLocation(location);
            pk.setIdentification(client);
            pk.setIdentificationType(type.toUpperCase());
            this.clientAddressService.deleteClientAdress(pk);
            return ResponseEntity.ok("Address successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteClientEntity(
            @RequestBody ClientAddress clientAddress) {
        try {
            this.clientAddressService.deleteClientAdress(clientAddress);
            return ResponseEntity.ok("Address successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}

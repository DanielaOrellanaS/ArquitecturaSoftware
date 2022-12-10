package com.banquito.corepasivos.client.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.model.ClientAddress;
import com.banquito.corepasivos.client.model.ClientAddressPK;
import com.banquito.corepasivos.client.service.ClientAddressService;
import com.banquito.corepasivos.utils.DTO;

@RestController
@RequestMapping("/api/client-address")
public class ClientAddressController {

    private final ClientAddressService clientAddressService;

    public ClientAddressController(ClientAddressService clientAddressService) {
        this.clientAddressService = clientAddressService;
    }

    @RequestMapping(value = "/{id}/{type}", method = RequestMethod.GET)
    public ResponseEntity<DTO<List<ClientAddress>>> findAllClientAddresses(
            @PathVariable("id") String id,
            @PathVariable("type") String type) {
        DTO<List<ClientAddress>> response = new DTO<>();
        try {
            List<ClientAddress> addresses = this.clientAddressService.findAddressByClientId(id, type.toUpperCase());
            response.setStatus(200);
            response.setMessage("Data found");
            response.setData(addresses);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(400);
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<DTO<ClientAddress>> createClientAddress(@RequestBody ClientAddress clientAddress) {
        DTO<ClientAddress> response = new DTO<>();
        try {
            this.clientAddressService.createClientAddress(clientAddress);
            response.setStatus(201);
            response.setMessage("Address successfully created");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.setStatus(400);
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @RequestMapping(value = "/{identification}/{type}/{location}", method = RequestMethod.PUT)
    public ResponseEntity<DTO<ClientAddress>> updateClientAddress(
            @PathVariable("identification") String client,
            @PathVariable("type") String type,
            @PathVariable("location") Integer location,
            @RequestBody ClientAddress clientAddress) {
        DTO<ClientAddress> response = new DTO<>();
        try {
            ClientAddressPK pk = new ClientAddressPK();
            pk.setCodeLocation(location);
            pk.setIdentification(client);
            pk.setIdentificationtype(type.toUpperCase());
            this.clientAddressService.updateClientAddress(pk, clientAddress);
            response.setStatus(200);
            response.setMessage("Address successfully updated");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(400);
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @RequestMapping(value = "/{identification}/{type}/{location}", method = RequestMethod.DELETE)
    public ResponseEntity<DTO<ClientAddress>> deleteClientAddress(
            @PathVariable("identification") String client,
            @PathVariable("type") String type,
            @PathVariable("location") Integer location) {
        DTO<ClientAddress> response = new DTO<>();
        try {
            ClientAddressPK pk = new ClientAddressPK();
            pk.setCodeLocation(location);
            pk.setIdentification(client);
            pk.setIdentificationtype(type.toUpperCase());
            this.clientAddressService.deleteClientAddress(pk);
            response.setStatus(200);
            response.setMessage("Address successfully updated");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(400);
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}

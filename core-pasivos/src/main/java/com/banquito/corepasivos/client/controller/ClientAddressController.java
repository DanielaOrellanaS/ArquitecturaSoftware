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

import com.banquito.corepasivos.client.dto.ClientAddressDto;
import com.banquito.corepasivos.client.mapper.ClientAddressMapper;
import com.banquito.corepasivos.client.model.ClientAddress;
import com.banquito.corepasivos.client.model.ClientAddressPK;
import com.banquito.corepasivos.client.service.ClientAddressService;

@RestController
@RequestMapping("/api/client-address")
public class ClientAddressController {

    private final ClientAddressService clientAddressService;

    public ClientAddressController(ClientAddressService clientAddressService) {
        this.clientAddressService = clientAddressService;
    }

    @RequestMapping(value = "/{id}/{type}", method = RequestMethod.GET)
    public ResponseEntity<List<ClientAddressDto>> findAllClientAddresses(
            @PathVariable("id") String id,
            @PathVariable("type") String type) {
        try {
            List<ClientAddress> addresses = this.clientAddressService.findAddressByClientId(id, type.toUpperCase());
            List<ClientAddressDto> dtos = addresses.stream().map(address -> ClientAddressMapper.map(address))
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(dtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createClientAddress(@RequestBody ClientAddressDto clientAddress) {
        try {
            ClientAddress address = ClientAddressMapper.map(clientAddress);
            this.clientAddressService.createClientAddress(address);
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully address created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{identification}/{type}/{location}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateClientAddress(
            @PathVariable("identification") String client,
            @PathVariable("type") String type,
            @PathVariable("location") Integer location,
            @RequestBody ClientAddressDto clientAddress) {
        try {
            ClientAddress address = ClientAddressMapper.map(clientAddress);
            ClientAddressPK pk = new ClientAddressPK();
            pk.setCodeLocation(location);
            pk.setIdentification(client);
            pk.setIdentificationtype(type.toUpperCase());
            this.clientAddressService.updateClientAddress(pk, address);
            return ResponseEntity.status(HttpStatus.OK).body("Address successfully updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{identification}/{type}/{location}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteClientAddress(
            @PathVariable("identification") String client,
            @PathVariable("type") String type,
            @PathVariable("location") Integer location) {
        try {
            ClientAddressPK pk = new ClientAddressPK();
            pk.setCodeLocation(location);
            pk.setIdentification(client);
            pk.setIdentificationtype(type.toUpperCase());
            this.clientAddressService.deleteClientAddress(pk);
            return ResponseEntity.status(HttpStatus.OK).body("Address successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

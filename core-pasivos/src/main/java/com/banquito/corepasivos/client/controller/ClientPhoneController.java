package com.banquito.corepasivos.client.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.model.ClientPhone;
import com.banquito.corepasivos.client.service.ClientPhoneService;

@RestController
@RequestMapping("/api/client-phone")
public class ClientPhoneController {    
    private final ClientPhoneService clientPhoneService;
    
    public ClientPhoneController(ClientPhoneService clientPhoneService) {
        this.clientPhoneService = clientPhoneService;
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ClientPhone save(@RequestBody ClientPhone clientPhone) {
        return this.clientPhoneService.save(clientPhone);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ClientPhone>> findAll() {
        List<ClientPhone> clientPhones = this.clientPhoneService.findAll();

        if (clientPhones.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(clientPhones);
    }

    @RequestMapping(value = "/{identification}", method = RequestMethod.GET)
    public ResponseEntity<List<ClientPhone>> findByIdentificationClient(
            @PathVariable("identification") String identification) {
        List<ClientPhone> phonesByIdentificationClient = this.clientPhoneService.findByIdentificationClient(identification);

        if (phonesByIdentificationClient.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(phonesByIdentificationClient);
    }

    @RequestMapping(value = "/{identification}", method = RequestMethod.PUT)
    public ClientPhone updateByIdentificationClient(@RequestBody ClientPhone clientPhone,
            @PathVariable("identification") String identification) {
        return this.clientPhoneService.updateByIdentificationClient(identification, clientPhone);
    }

    @RequestMapping(value = "/{identification}", method = RequestMethod.DELETE)
    public ClientPhone deleteByIdentificationClient(
            @PathVariable("identification") String identification) {
        return this.clientPhoneService.deleteByIdentificationClient(identification);
    }
}

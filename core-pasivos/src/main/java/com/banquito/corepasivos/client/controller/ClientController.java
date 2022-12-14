package com.banquito.corepasivos.client.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.dto.request.RequestDtoClient;
import com.banquito.corepasivos.client.dto.response.ResponseDtoClient;
import com.banquito.corepasivos.client.mapper.ClientMapper;
import com.banquito.corepasivos.client.model.Client;
import com.banquito.corepasivos.client.model.ClientPK;
import com.banquito.corepasivos.client.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/{id}/{type}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDtoClient> findAllClientsByIdentification(
            @PathVariable("id") String id,
            @PathVariable("type") String type) {
        ClientPK pk = new ClientPK();
        pk.setIdentification(id);
        pk.setIdentificationType(type.toUpperCase());
        try {
            Client client = this.clientService.findClient(pk);
            if (!client.equals(null)) {
                ResponseDtoClient dto = ClientMapper.map(client);
                return ResponseEntity.status(HttpStatus.OK).body(dto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createClient(@RequestBody RequestDtoClient dto) {
        try {
            Client client = ClientMapper.map(dto);
            this.clientService.createClient(client);
            return ResponseEntity.status(HttpStatus.OK).body("Client successfully created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{id}/{type}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateClient(
            @PathVariable("id") String id,
            @PathVariable("type") String type,
            @RequestBody RequestDtoClient dto) {
        ClientPK pk = new ClientPK();
        pk.setIdentification(id);
        pk.setIdentificationType(type.toUpperCase());
        try {
            Client client = ClientMapper.map(dto);
            this.clientService.updateClient(pk, client);
            return ResponseEntity.status(HttpStatus.OK).body("Client successfully updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{id}/{type}", method = RequestMethod.DELETE)
    public ResponseEntity<String> updateStatus(
            @PathVariable("id") String id,
            @PathVariable("type") String type) {
        ClientPK pk = new ClientPK();
        pk.setIdentification(id);
        pk.setIdentificationType(type.toUpperCase());
        try {
            this.clientService.updateStatus(pk);
            return ResponseEntity.status(HttpStatus.OK).body("Client successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
package com.banquito.corepasivos.client.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.model.Client;
import com.banquito.corepasivos.client.model.ClientPK;
import com.banquito.corepasivos.client.service.ClientService;
import com.banquito.corepasivos.utils.TTO;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/client/{id}/{type}", method = RequestMethod.GET)
    public ResponseEntity<TTO<Client>> findAllClientsByIdentification(
            @PathVariable("id") String id,
            @PathVariable("type") String type) {
        TTO<Client> response = new TTO<>();
        ClientPK pk = new ClientPK();
        pk.setIdentification(id);
        pk.setIdentificationType(type.toUpperCase());
        try {
            Client client = this.clientService.findClient(pk);
            if (client.equals(null)) {
                response.setStatus(404);
                response.setMessage("Data not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            } else {
                response.setStatus(200);
                response.setMessage("Data found");
                response.setData(client);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (Exception e) {
            response.setStatus(500);
            response.setMessage("An error occurs");
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<TTO<Client>> createClient(@RequestBody Client client) {
        TTO<Client> response = new TTO<>();
        try {
            response.setStatus(200);
            response.setMessage("Client successfully created");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(400);
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @RequestMapping(value = "/{id}/{type}", method = RequestMethod.PUT)
    public ResponseEntity<TTO<Client>> updateClient(
            @PathVariable("id") String id,
            @PathVariable("type") String type,
            @RequestBody Client client) {
        TTO<Client> response = new TTO<>();
        ClientPK pk = new ClientPK();
        pk.setIdentification(id);
        pk.setIdentificationType(type.toUpperCase());
        try {
            this.clientService.updateClient(pk, client);
            response.setStatus(200);
            response.setMessage("Client successfully updated");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(400);
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @RequestMapping(value = "/{id}/{type}", method = RequestMethod.DELETE)
    public ResponseEntity<TTO<Client>> updateStatus(
            @PathVariable("id") String id,
            @PathVariable("type") String type) {
        TTO<Client> response = new TTO<>();
        ClientPK pk = new ClientPK();
        pk.setIdentification(id);
        pk.setIdentificationType(type.toUpperCase());
        try {
            this.clientService.updateStatus(pk);
            response.setStatus(200);
            response.setMessage("Client successfully deleted");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(400);
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
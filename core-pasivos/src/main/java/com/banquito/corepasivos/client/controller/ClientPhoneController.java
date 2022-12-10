package com.banquito.corepasivos.client.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.model.ClientPhone;
import com.banquito.corepasivos.client.model.ClientPhonePK;
import com.banquito.corepasivos.client.service.ClientPhoneService;
import com.banquito.corepasivos.utils.DTO;

@RestController
@RequestMapping("/api/client-phone")
public class ClientPhoneController {
    private final ClientPhoneService clientPhoneService;

    public ClientPhoneController(ClientPhoneService clientPhoneService) {
        this.clientPhoneService = clientPhoneService;
    }

    @RequestMapping(value = "/{id}/{type}", method = RequestMethod.GET)
    public ResponseEntity<DTO<List<ClientPhone>>> findByClient(
            @PathVariable("id") String id,
            @PathVariable("type") String type) {
        DTO<List<ClientPhone>> response = new DTO<>();
        try {
            List<ClientPhone> phones = this.clientPhoneService.findByClient(id, type.toUpperCase());
            response.setStatus(200);
            response.setMessage("Data found");
            response.setData(phones);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<DTO<ClientPhone>> createPhone(@RequestBody ClientPhone clientPhone) {
        DTO<ClientPhone> response = new DTO<>();
        try {
            this.clientPhoneService.createPhone(clientPhone);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Phone successfully created");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @RequestMapping(value = "/{id}/{type}/{phone}", method = RequestMethod.PUT)
    public ResponseEntity<DTO<ClientPhone>> updatePhone(
            @PathVariable("id") String id,
            @PathVariable("type") String type,
            @PathVariable("phone") String phone,
            @RequestBody ClientPhone clientPhone) {
        DTO<ClientPhone> response = new DTO<>();
        try {
            ClientPhonePK pk = new ClientPhonePK();
            pk.setIdentification(id);
            pk.setIdentificationtype(type.toUpperCase());
            pk.setPhonenumber(phone);
            this.clientPhoneService.updateById(pk, clientPhone);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Phone successfully updated");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @RequestMapping(value = "/{id}/{type}/{phone}", method = RequestMethod.DELETE)
    public ResponseEntity<DTO<ClientPhone>> deletePhone(
            @PathVariable("id") String id,
            @PathVariable("type") String type,
            @PathVariable("phone") String phone) {
        DTO<ClientPhone> response = new DTO<>();
        try {
            ClientPhonePK pk = new ClientPhonePK();
            pk.setIdentification(id);
            pk.setIdentificationtype(type.toUpperCase());
            pk.setPhonenumber(phone);
            this.clientPhoneService.deleteById(pk);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Phone successfully updated");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @RequestMapping(value = "/{id}/{type}", method = RequestMethod.DELETE)
    public ResponseEntity<DTO<ClientPhone>> deletePhones(
            @PathVariable("id") String id,
            @PathVariable("type") String type) {
        DTO<ClientPhone> response = new DTO<>();
        try {
            this.clientPhoneService.deletePhones(id, type);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Phones successfully deleted");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}

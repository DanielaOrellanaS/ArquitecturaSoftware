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

import com.banquito.corepasivos.client.dto.request.RequestDtoClientPhone;
import com.banquito.corepasivos.client.dto.response.ResponseDtoClientPhone;
import com.banquito.corepasivos.client.mapper.ClientPhoneMapper;
import com.banquito.corepasivos.client.model.ClientPhone;
import com.banquito.corepasivos.client.service.ClientPhoneService;

@RestController
@RequestMapping("/api/client-phone")
public class ClientPhoneController {
    private final ClientPhoneService clientPhoneService;

    public ClientPhoneController(ClientPhoneService clientPhoneService) {
        this.clientPhoneService = clientPhoneService;
    }

    @RequestMapping(value = "/{identification}/{identificationType}", method = RequestMethod.GET)
    public ResponseEntity<List<ResponseDtoClientPhone>> findByIdentification(
            @PathVariable("identification") String identification,
            @PathVariable("identificationType") String identificationType) {
        try {
            List<ClientPhone> phones = this.clientPhoneService.findByIdentification(identification,
                    identificationType.toUpperCase());
            List<ResponseDtoClientPhone> dtos = phones.stream().map(phone -> ClientPhoneMapper.map(phone))
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(dtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createPhone(@RequestBody RequestDtoClientPhone clientPhone) {
        try {
            ClientPhone phone = ClientPhoneMapper.map(clientPhone);
            this.clientPhoneService.createPhone(phone);
            return ResponseEntity.status(HttpStatus.OK).body("Phone successfully created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{identification}/{identificationType}/{phone}", method = RequestMethod.PUT)
    public ResponseEntity<String> updatePhone(
            @PathVariable("identification") String identification,
            @PathVariable("identificationType") String identificationType,
            @PathVariable("phone") String phone,
            @RequestBody RequestDtoClientPhone dto) {
        try {
            ClientPhone clientPhone = ClientPhoneMapper.map(dto);
            this.clientPhoneService.updateById(identification, identificationType, phone, clientPhone);
            return ResponseEntity.status(HttpStatus.OK).body("Phone successfully updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{identification}/{identificationType}/{phone}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePhone(
            @PathVariable("identification") String identification,
            @PathVariable("identificationType") String identificationType,
            @PathVariable("phone") String phone) {
        try {
            this.clientPhoneService.deleteById(identification, identificationType, phone);
            return ResponseEntity.status(HttpStatus.OK).body("Phone successfully updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{identification}/{identificationType}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePhones(
            @PathVariable("identification") String identification,
            @PathVariable("identificationType") String identificationType) {
        try {
            this.clientPhoneService.deletePhones(identification, identificationType);
            return ResponseEntity.status(HttpStatus.OK).body("Phones successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

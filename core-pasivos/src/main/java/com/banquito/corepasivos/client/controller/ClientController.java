package com.banquito.corepasivos.client.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.model.Client;
import com.banquito.corepasivos.client.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
//
//    private final ClientService clientService;
//
//    public ClientController(ClientService clientService) {
//        this.clientService = clientService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Client>> findAll() {
//        return ResponseEntity.ok(this.clientService.findAllClients());
//    }

}

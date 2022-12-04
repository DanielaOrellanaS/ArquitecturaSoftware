package com.banquito.corepasivos.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public Object findClient() {
        return this.clientService.findAllClient();
    }
    
    
}

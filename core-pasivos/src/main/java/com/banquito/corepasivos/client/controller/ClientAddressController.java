package com.banquito.corepasivos.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.service.ClientAddressService;

@RestController
@RequestMapping("/clientaddress")
public class ClientAddressController {
    @Autowired
    ClientAddressService clientAddressService;

    @GetMapping("/all")
    public Object getClientAddress() {
        return this.clientAddressService.getAllClientAddress();
    }
}

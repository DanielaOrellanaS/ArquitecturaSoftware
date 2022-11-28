package com.banquito.corepasivos.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.service.ClientPhoneService;

@RestController
@RequestMapping("/clientphone")
public class ClientPhoneController {

    @Autowired
    ClientPhoneService clientPhoneService;

    @RequestMapping("/all")
    public Object getAllClientPhones(){
        return this.clientPhoneService.getAllClientPhones();
    }
}

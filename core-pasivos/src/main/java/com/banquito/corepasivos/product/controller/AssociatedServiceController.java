package com.banquito.corepasivos.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.product.service.AssociatedServiceService;

@RestController
@RequestMapping("/associatedservice")
public class AssociatedServiceController {

    @Autowired
    AssociatedServiceService associatedServiceService;

    @GetMapping("/all")
    public Object findAllAssociatedServices() {
        return this.associatedServiceService.findAllAssociatedServices();
    }
}

package com.banquito.corepasivos.product.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.product.model.AssociatedService;
import com.banquito.corepasivos.product.service.AssociatedServiceService;

@RestController
@RequestMapping("/associatedService")
public class AssociatedServiceController {

    private final AssociatedServiceService service;

    public AssociatedServiceController(AssociatedServiceService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public void saveAssociatedService(AssociatedService associatedService) {
        this.service.saveAssociatedService(associatedService);
    }
    
}

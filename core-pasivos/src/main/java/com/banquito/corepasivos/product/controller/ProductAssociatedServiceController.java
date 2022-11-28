package com.banquito.corepasivos.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.product.model.ProductAssociatedService;
import com.banquito.corepasivos.product.service.ProductAssociatedServiceService;

@RestController
@RequestMapping("/productassociatedservice")
public class ProductAssociatedServiceController {
    @Autowired
    ProductAssociatedServiceService productAssociatedServiceService;

    @GetMapping("/all")
    public List<ProductAssociatedService> readProductAssociatedServices() {
        return this.productAssociatedServiceService.getAllProductAssociatedServices();
    }

}

package com.banquito.corepasivos.product.controller;

import com.banquito.corepasivos.product.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producttype")
public class ProductTypeController {

    @Autowired
    ProductTypeService productTypeService;

    @GetMapping("/all")
    public Object findProductType() {
        return this.productTypeService.readAllProductTypes();
    }

}

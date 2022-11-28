package com.banquito.corepasivos.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.product.model.Product;
import com.banquito.corepasivos.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> readProducts() {
        return this.productService.readAllProducts();
    }

    @GetMapping("/type/{codeProductType}")
    public List<Product> readProductsByCodeProductType(@PathVariable("codeProductType") String codeProductType) {
        return this.productService.readByCodeProductType(codeProductType);
    }

    @GetMapping("/code/{codeProduct}")
    public Product readProductByCodeProduct(@PathVariable("codeProduct") String codeProduct) {
        return this.productService.readByCodeProduct(codeProduct);
    }

}

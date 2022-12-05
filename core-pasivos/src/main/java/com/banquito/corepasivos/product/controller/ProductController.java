package com.banquito.corepasivos.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.product.model.Product;
import com.banquito.corepasivos.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = this.productService.findAllProducts();
        return products.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(products);
    }

    @GetMapping("/code/type/{codeProductType}")
    public ResponseEntity<List<Product>> findByCodeProductType(@PathVariable("codeProductType") String codeProductType) {
        List<Product> products = this.productService.findByCodeProductType(codeProductType);
        return products.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(products);
    }

    @GetMapping("/code/{codeProduct}")
    public ResponseEntity<Product> findByCodeProduct(@PathVariable("codeProduct") String codeProduct) {
        Product product = this.productService.findByCodeProduct(codeProduct);
        return product == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(product);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Product> findByName(@PathVariable("name") String name) {
        Product product = this.productService.findByName(name);
        return product == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(product);
    }

    @PostMapping
    public void createProduct(Product product) {
        productService.createProduct(product);
    }
    
}

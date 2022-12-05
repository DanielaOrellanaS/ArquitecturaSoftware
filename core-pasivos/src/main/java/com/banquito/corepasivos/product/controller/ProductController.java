package com.banquito.corepasivos.product.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.product.model.Product;
import com.banquito.corepasivos.product.model.ProductPK;
import com.banquito.corepasivos.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = this.productService.findAllProducts();
        return products.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(products);
    }

    @GetMapping("/codetype/{codeProductType}")
    public ResponseEntity<List<Product>> findByCodeProductType(@PathVariable("codeProductType") String codeProductType) {
        List<Product> products = this.productService.findByCodeProductType(codeProductType);
        return products.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(products);
    }

    @GetMapping("/code/{codeProduct}")
    public ResponseEntity<Product> findByCodeProduct(@PathVariable("codeProduct") String codeProduct) {
        Product product = this.productService.findByCodeProduct(codeProduct);
        return product == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(product);
    }

    @GetMapping("/name/contains/{name}")
    public ResponseEntity<List<Product>> findByNameContains(@PathVariable("name") String name) {
        List<Product> products = this.productService.findByNameContaining(name);
        return products.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(products);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Product> findByName(@PathVariable("name") String name) {
        Product product = this.productService.findByName(name);
        return product == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(product);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        try {
            this.productService.createProduct(product);
            return ResponseEntity.ok("Product created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping(consumes = { "application/json" })
    public ResponseEntity<String> updateProduct(
            @RequestBody Product product) {
        try {
            this.productService.updateProduct(product);
            return ResponseEntity.ok("Product updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/code/{codeProduct}/codetype/{codeProductType}")
    public ResponseEntity<String> deleteProduct(
        @PathVariable("codeProduct") String codeProduct, 
        @PathVariable("codeProductType") String codeProductType
    ) {
        try {
            ProductPK pk = new ProductPK();
            pk.setCodeProduct(codeProduct);
            pk.setCodeProductType(codeProductType);
            this.productService.deleteProduct(pk);
            return ResponseEntity.ok("Product removed successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    
}

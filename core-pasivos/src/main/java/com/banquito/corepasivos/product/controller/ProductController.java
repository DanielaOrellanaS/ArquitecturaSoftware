package com.banquito.corepasivos.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = this.productService.findAllProducts();
        return products.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(products);
    }

    @RequestMapping(value = "/{codeProduct}/{codeProductType}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Product>> findById(
        @PathVariable("codeProduct") String codeProduct, 
        @PathVariable("codeProductType") String codeProductType
    ) {
        ProductPK pk = new ProductPK();
        pk.setCodeProduct(codeProduct);
        pk.setCodeProductType(codeProductType);
        Optional<Product> products = this.productService.findById(pk);
        return products.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(products);
    }

    @RequestMapping(value = "/name-contain/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findByNameContains(@PathVariable("name") String name) {
        List<Product> products = this.productService.findByNameContaining(name);
        return products.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(products);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Product> findByName(@PathVariable("name") String name) {
        Product product = this.productService.findByName(name);
        return product == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(product);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        try {
            this.productService.createProduct(product);
            return ResponseEntity.ok("Product created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{codeProduct}/{codeProductType}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProduct(
        @PathVariable("codeProduct") String codeProduct, 
        @PathVariable("codeProductType") String codeProductType,
        @RequestBody Product product
    ) {
        try {
            ProductPK pk = new ProductPK();
            pk.setCodeProduct(codeProduct);
            pk.setCodeProductType(codeProductType);
            this.productService.updateProduct(pk, product);
            return ResponseEntity.ok("Product updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{codeProduct}/{codeProductType}", method = RequestMethod.DELETE)
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

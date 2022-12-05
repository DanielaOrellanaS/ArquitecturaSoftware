package com.banquito.corepasivos.product.controller;

import java.util.List;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.product.model.ProductType;
// import com.banquito.corepasivos.product.repository.ProductTypeRepository;
import com.banquito.corepasivos.product.service.ProductTypeService;

@RestController
@RequestMapping("/productTypes")
public class ProductTypeController {
    
        private final ProductTypeService productTypeService;

        public ProductTypeController(ProductTypeService productTypeService) {
            this.productTypeService = productTypeService;
        }

        @GetMapping
        public ResponseEntity<List<ProductType>> findAll() {
            List<ProductType> productTypes = this.productTypeService.findAllProductTypes();
            return productTypes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productTypes);
        }

        @GetMapping("/code/{codeProductType}")
        public ResponseEntity<ProductType> findByCodeProductType(@PathVariable("codeProductType") String codeProductType) {
            ProductType productType = this.productTypeService.findByCodeProductType(codeProductType);
            return productType == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(productType);
        }

        @GetMapping("/name/{name}")
        public ResponseEntity<ProductType> findByName(@PathVariable("name") String name) {
            ProductType productType = this.productTypeService.findByName(name);
            return productType == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(productType);
        }

        // contains
        @GetMapping("/name/contains/{name}")
        public ResponseEntity<List<ProductType>> findByNameContains(@PathVariable("name") String name) {
            List<ProductType> productTypes = this.productTypeService.findByNameContaining(name);
            return productTypes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productTypes);
        }

        @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity<String> createProductType(@RequestBody ProductType productType) {
            try {
                String productTypeCreated = this.productTypeService.createProductType(productType);
                return ResponseEntity.ok(productTypeCreated);

            } catch (Exception e) {
                return ResponseEntity.badRequest().build();
            }
        }
}

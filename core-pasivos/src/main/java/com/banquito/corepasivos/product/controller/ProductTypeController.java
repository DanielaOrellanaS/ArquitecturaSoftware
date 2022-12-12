package com.banquito.corepasivos.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.product.model.ProductType;
import com.banquito.corepasivos.product.service.ProductTypeService;

@RestController
@RequestMapping("/api/product-types")
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<List<ProductType>> findAll() {
        List<ProductType> productTypes = this.productTypeService.findAllProductTypes();
        return productTypes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productTypes);
    }

    @RequestMapping(value = "/code/{codeProductType}", method = RequestMethod.GET)
    public ResponseEntity<ProductType> findByCodeProductType(@PathVariable("codeProductType") String codeProductType) {
        ProductType productType = this.productTypeService.findByCodeProductType(codeProductType);
        return productType == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(productType);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<ProductType> findByName(@PathVariable("name") String name) {
        ProductType productType = this.productTypeService.findByName(name);
        return productType == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(productType);
    }

    // contains
    @RequestMapping(value = "/name/contains/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductType>> findByNameContains(@PathVariable("name") String name) {
        List<ProductType> productTypes = this.productTypeService.findByNameContaining(name);
        return productTypes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productTypes);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createProductType(@RequestBody ProductType productType) {
        try {
            String productTypeCreated = this.productTypeService.createProductType(productType);
            return ResponseEntity.ok(productTypeCreated);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAssociatedService(@RequestBody ProductType productType) {
        try {
            this.productTypeService.updateProductType(productType);
            return ResponseEntity.ok("Service updated successfully");

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAssociatedService(@PathVariable("id") String id) {
        try {
            this.productTypeService.deleteProductType(id);
            return ResponseEntity.ok("Service deleted successfully");

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    // bytype
    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductType>> findByType(@PathVariable("type") String type) {
        List<ProductType> productTypes = this.productTypeService.findByType(type);
        return productTypes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productTypes);
    }
}

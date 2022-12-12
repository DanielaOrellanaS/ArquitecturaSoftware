package com.banquito.corepasivos.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.product.model.ProductAssociatedService;
import com.banquito.corepasivos.product.model.ProductAssociatedServicePK;
import com.banquito.corepasivos.product.service.ProductAssociatedServiceService;

@RestController
@RequestMapping("/api/product-associated-services")
public class ProductAssociatedServiceController {

    private final ProductAssociatedServiceService productAssociatedService;

    public ProductAssociatedServiceController(ProductAssociatedServiceService productAssociatedService) {
        this.productAssociatedService = productAssociatedService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ProductAssociatedService>> findAll() {
        List<ProductAssociatedService> productAssociatedServices = this.productAssociatedService.findAllProductAssociatedServices();
        return productAssociatedServices.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productAssociatedServices);
    }

    @RequestMapping(value = "/{codeAssociatedService}/{codeProduct}/{codeProductType}", method = RequestMethod.GET)
    public ResponseEntity<Optional<ProductAssociatedService>> findById(
        @PathVariable("codeAssociatedService") String codeAssociatedService,     
        @PathVariable("codeProduct") String codeProduct, 
        @PathVariable("codeProductType") String codeProductType
    ) {
        ProductAssociatedServicePK pk = new ProductAssociatedServicePK();
        pk.setCodeAssociatedService(codeAssociatedService);
        pk.setCodeProduct(codeProduct);
        pk.setCodeProductType(codeProductType);
        Optional<ProductAssociatedService> productAssociatedServices = this.productAssociatedService.findById(pk);
        return productAssociatedServices.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productAssociatedServices);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createProductAssociatedService(@RequestBody ProductAssociatedService productAssociatedService) {
        try {
            this.productAssociatedService.createProductAssociatedService(productAssociatedService);
            return ResponseEntity.ok("Product associated service created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{codeAssociatedService}/{codeProduct}/{codeProductType}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProduct(
        @PathVariable("codeAssociatedService") String codeAssociatedService,     
        @PathVariable("codeProduct") String codeProduct, 
        @PathVariable("codeProductType") String codeProductType,
        @RequestBody ProductAssociatedService productAssociatedService
    ) {
        try {
            ProductAssociatedServicePK pk = new ProductAssociatedServicePK();
            pk.setCodeAssociatedService(codeAssociatedService);
            pk.setCodeProduct(codeProduct);
            pk.setCodeProductType(codeProductType);
            this.productAssociatedService.updateProductAssociatedService(pk, productAssociatedService);
            return ResponseEntity.ok("Product associated service updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{codeAssociatedService}/{codeProduct}/{codeProductType}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProduct(
        @PathVariable("codeAssociatedService") String codeAssociatedService,     
        @PathVariable("codeProduct") String codeProduct, 
        @PathVariable("codeProductType") String codeProductType
    ) {
        try {
            ProductAssociatedServicePK pk = new ProductAssociatedServicePK();
            pk.setCodeAssociatedService(codeAssociatedService);
            pk.setCodeProduct(codeProduct);
            pk.setCodeProductType(codeProductType);
            this.productAssociatedService.deleteProductAssociatedService(pk);
            return ResponseEntity.ok("Product associated service removed successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    
}

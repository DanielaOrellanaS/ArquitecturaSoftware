package com.banquito.corepasivos.product.controller;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

   /*  @GetMapping("/{codeAssociatedService}")
    public ResponseEntity<AssociatedService> findByCodeAssociatedService(@PathVariable("codeAssociatedService") String codeAssociatedService) {
        AssociatedService service = this.service.findById(codeAssociatedService);
        return service == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(service);
    } */

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> saveAssociatedService(@RequestBody AssociatedService associatedService) {
        this.service.saveAssociatedService(associatedService);
        return ResponseEntity.ok("Servicio creado con exito");

    }

}

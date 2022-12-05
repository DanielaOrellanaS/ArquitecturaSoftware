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

import com.banquito.corepasivos.product.model.AssociatedService;
import com.banquito.corepasivos.product.service.AssociatedServiceService;

@RestController
@RequestMapping("/api/associatedservices")
public class AssociatedServiceController {

    private final AssociatedServiceService associatedServiceService;

    public AssociatedServiceController(AssociatedServiceService associatedServiceService) {
        this.associatedServiceService = associatedServiceService;
    }

    @GetMapping("/{codeAssociatedService}")
    public ResponseEntity<AssociatedService> CodeAssociatedService(
            @PathVariable("codeAssociatedService") String codeAssociatedService) {
        List<AssociatedService> service = this.associatedServiceService
                .findByCodeAssociatedService(codeAssociatedService);
        return service == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(service.get(0));
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> createAssociatedService(@RequestBody AssociatedService associatedService) {
        try {
            this.associatedServiceService.saveAssociatedService(associatedService);
            return ResponseEntity.ok("Servicio creado con exito");

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}

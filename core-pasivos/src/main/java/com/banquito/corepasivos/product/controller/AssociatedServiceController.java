package com.banquito.corepasivos.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.product.model.AssociatedService;
import com.banquito.corepasivos.product.service.AssociatedServiceService;

@RestController
@RequestMapping("/api/associated-services")
public class AssociatedServiceController {

    private final AssociatedServiceService associatedServiceService;

    public AssociatedServiceController(AssociatedServiceService associatedServiceService) {
        this.associatedServiceService = associatedServiceService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<AssociatedService>> findAllAssociatedService() {
        List<AssociatedService> associatedService = this.associatedServiceService
                .findAllAssociatedService();
        return ResponseEntity.ok(associatedService);
    }

    @RequestMapping(value = "/{codeAssociatedService}", method = RequestMethod.GET)
    public ResponseEntity<AssociatedService> CodeAssociatedService(
            @PathVariable("codeAssociatedService") String codeAssociatedService) {
        List<AssociatedService> service = this.associatedServiceService
                .findByCodeAssociatedService(codeAssociatedService);
        return service == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(service.get(0));
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<AssociatedService>> findByNameContainins(@PathVariable("name") String name) {

        List<AssociatedService> service = this.associatedServiceService.findByNameContaining(name.toUpperCase());
        return service.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(service);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createAssociatedService(@RequestBody AssociatedService associatedService) {
        try {
            this.associatedServiceService.saveAssociatedService(associatedService);
            return ResponseEntity.ok("Service created successfully");

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAssociatedService(@RequestBody AssociatedService associatedService) {
        try {
            this.associatedServiceService.updateAssociatedService(associatedService);
            return ResponseEntity.ok("Service updated successfully");

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{codeAssociatedService}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAssociatedService(@PathVariable("codeAssociatedService") String codeAssociatedService) {
        try {
            this.associatedServiceService.deleteAssociatedService(codeAssociatedService);
            return ResponseEntity.ok("Service removed successfully");

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}

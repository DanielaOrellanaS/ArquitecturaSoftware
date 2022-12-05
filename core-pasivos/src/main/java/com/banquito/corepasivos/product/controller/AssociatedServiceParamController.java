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

import com.banquito.corepasivos.product.service.AssociatedServiceParamService;
import com.banquito.corepasivos.product.model.AssociatedServiceParam;
import com.banquito.corepasivos.product.model.AssociatedServiceParamPK;

@RestController
@RequestMapping("/associatedserviceparam")
public class AssociatedServiceParamController {
    private final AssociatedServiceParamService associatedServiceParamService;

    public AssociatedServiceParamController(AssociatedServiceParamService associatedServiceParamService) {
        this.associatedServiceParamService = associatedServiceParamService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AssociatedServiceParam>> findAllAssociatedServiceParam() {
        List<AssociatedServiceParam> clientAddresses = this.associatedServiceParamService
                .findAllAssociatedServiceParams();
        return ResponseEntity.ok(clientAddresses);
    }

    @GetMapping("/param/{codeParam}")
    public ResponseEntity<List<AssociatedServiceParam>> findByCodeParam(@PathVariable("codeParam") String codeParam) {
        List<AssociatedServiceParam> clientAddresses = this.associatedServiceParamService
                .findAllAssociatedServiceParamsByCodeParam(codeParam);
        return ResponseEntity.ok(clientAddresses);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> createClientAddress(@RequestBody AssociatedServiceParam associatedServiceParam) {
        try {
            this.associatedServiceParamService.createAssociatedServiceParam(associatedServiceParam);
            return ResponseEntity.ok("Parametros del servicio asociado creado con exito");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping(consumes = { "application/json" })
    public ResponseEntity<String> updateClientAddress(
            @RequestBody AssociatedServiceParam associatedServiceParam) {
        try {
            this.associatedServiceParamService.updateAssociatedServiceParam(associatedServiceParam);
            return ResponseEntity.ok("Parametros de servicio asociado atualizado con exito");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{codeParam}/{codeAssociatedService}")
    public ResponseEntity<String> deleteClientEntity(
            @PathVariable("codeParam") String codeParam,
            @PathVariable("codeAssociatedService") String codeAssociatedService) {
        try {
            AssociatedServiceParamPK pk = new AssociatedServiceParamPK();
            pk.setCodeParam(codeParam);
            pk.setCodeAssociatedService(codeAssociatedService);

            this.associatedServiceParamService.deleteAssociatedServiceParam(pk);
            return ResponseEntity.ok("Direccion eliminada con exito");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteClientEntity(
            @RequestBody AssociatedServiceParam associatedServiceParam) {
        try {
            this.associatedServiceParamService.deleteAssociatedServiceParam(associatedServiceParam);
            return ResponseEntity.ok("Parámetros de servicio asociado eliminados con exito");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}

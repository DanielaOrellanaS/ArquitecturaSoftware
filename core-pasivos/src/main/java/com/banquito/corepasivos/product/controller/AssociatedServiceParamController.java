package com.banquito.corepasivos.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.product.service.AssociatedServiceParamService;
import com.banquito.corepasivos.product.model.AssociatedServiceParam;
import com.banquito.corepasivos.product.model.AssociatedServiceParamPK;

@RestController
@RequestMapping("api/associated-service-params")
public class AssociatedServiceParamController {
    private final AssociatedServiceParamService associatedServiceParamService;

    public AssociatedServiceParamController(AssociatedServiceParamService associatedServiceParamService) {
        this.associatedServiceParamService = associatedServiceParamService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<AssociatedServiceParam>> findAllAssociatedServiceParam() {
        List<AssociatedServiceParam> associatedServiceParam = this.associatedServiceParamService
                .findAllAssociatedServiceParams();
        return associatedServiceParam.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(associatedServiceParam);
    }

    @RequestMapping(value = "/param/{codeParam}", method = RequestMethod.GET)
    public ResponseEntity<List<AssociatedServiceParam>> findByCodeParam(@PathVariable("codeParam") String codeParam) {
        List<AssociatedServiceParam> associatedServiceParam = this.associatedServiceParamService
                .findAllAssociatedServiceParamsByCodeParam(codeParam);
        return associatedServiceParam.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(associatedServiceParam);
    }

    @RequestMapping(value = "/associatedservice/{codeAssociatedService}", method = RequestMethod.GET)
    public ResponseEntity<List<AssociatedServiceParam>> findByCodeAssociatedService(
            @PathVariable("codeAssociatedService") String codeAssociatedService) {
        List<AssociatedServiceParam> associatedServiceParam = this.associatedServiceParamService
                .findAllAssociatedServiceParamsByCodeAssociatedService(codeAssociatedService);
        return associatedServiceParam.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(associatedServiceParam);
    }

    @RequestMapping(value = "/nameparam/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<AssociatedServiceParam>> findByNameParam(@PathVariable("name") String name) {
        List<AssociatedServiceParam> associatedServiceParam = this.associatedServiceParamService
                .findByNameContaining(name);
        return associatedServiceParam.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(associatedServiceParam);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createAssociatedServiceParam(
            @RequestBody AssociatedServiceParam associatedServiceParam) {
        try {
            this.associatedServiceParamService.createAssociatedServiceParam(associatedServiceParam);
            return ResponseEntity.ok("Parameters of the associated service created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAssociatedServiceParam(
            @RequestBody AssociatedServiceParam associatedServiceParam) {
        try {
            this.associatedServiceParamService.updateAssociatedServiceParam(associatedServiceParam);
            return ResponseEntity.ok("Parameters of associated service updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{codeParam}/{codeAssociatedService}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAssociatedServiceParamEntity(
            @PathVariable("codeParam") String codeParam,
            @PathVariable("codeAssociatedService") String codeAssociatedService) {
        try {
            AssociatedServiceParamPK pk = new AssociatedServiceParamPK();
            pk.setCodeParam(codeParam);
            pk.setCodeAssociatedService(codeAssociatedService);

            this.associatedServiceParamService.deleteAssociatedServiceParam(pk);
            return ResponseEntity.ok("Associated Service Parameters Removed Successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}

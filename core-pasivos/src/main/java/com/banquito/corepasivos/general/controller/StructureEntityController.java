package com.banquito.corepasivos.general.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.general.model.StructureEntity;
import com.banquito.corepasivos.general.service.StructureEntityService;

@RestController
@RequestMapping("/api/structure")
public class StructureEntityController {
    private final StructureEntityService structureEntityService;

    public StructureEntityController(StructureEntityService structureEntityService) {
        this.structureEntityService = structureEntityService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<StructureEntity>> getStructureEntities() {
        return ResponseEntity.ok(this.structureEntityService.findAll());
    }

    @RequestMapping(value = "/{codeCountry}", method = RequestMethod.GET)
    public ResponseEntity<List<StructureEntity>> getStructureEntitiesByCodeCountry(@PathVariable("codeCountry") String codeCountry) {
        return ResponseEntity.ok(this.structureEntityService.findAllByCodeCountry(codeCountry));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createStructureEntity(@RequestBody StructureEntity structureEntity) {
        try {
            this.structureEntityService.create(structureEntity);
            ;
            return ResponseEntity.ok("Structure Entity created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<String> updateStructureEntity(@RequestBody StructureEntity structureEntity) {
        try {
            this.structureEntityService.update(structureEntity);
            return ResponseEntity.ok("Structure Entity updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStructureEntityy(@RequestBody StructureEntity structureEntity) {
        try {
            this.structureEntityService.delete(structureEntity);
            return ResponseEntity.ok("Structure Entity delete successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}

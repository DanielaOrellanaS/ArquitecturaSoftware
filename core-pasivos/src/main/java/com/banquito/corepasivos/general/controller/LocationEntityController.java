package com.banquito.corepasivos.general.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.general.model.LocationEntity;
import com.banquito.corepasivos.general.service.LocationEntityService;

@RestController
@RequestMapping("/api/location")
public class LocationEntityController {
    private final LocationEntityService locationEntityService;

    public LocationEntityController(LocationEntityService locationEntityService) {
        this.locationEntityService = locationEntityService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<LocationEntity>> getLocationEntities() {
        return ResponseEntity.ok(this.locationEntityService.findAll());
    }

    @RequestMapping(value = "/{codeLocation}", method = RequestMethod.GET)
    public ResponseEntity<LocationEntity> getLocationEntityById(@PathVariable("codeLocation") Integer codeLocation) {
        return ResponseEntity.ok(this.locationEntityService.findById(codeLocation));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createLocatioEntity(@RequestBody LocationEntity locationEntity) {
        try {
            this.locationEntityService.create(locationEntity);
            return ResponseEntity.ok("Location Entity created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<String> updateLocationEntity(@RequestBody LocationEntity locationEntity) {
        try {
            this.locationEntityService.update(locationEntity);
            return ResponseEntity.ok("Location Entity updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteLocationEntity(@RequestBody LocationEntity locationEntity) {
        try {
            this.locationEntityService.delete(locationEntity);
            return ResponseEntity.ok("Location Entity delete successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{codeLocation}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteLocationEntityById(@PathVariable("codeLocation") Integer codeLocation) {
        try {
            this.locationEntityService.deleteByCode(codeLocation);
            return ResponseEntity.ok("Location Entity delete successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}

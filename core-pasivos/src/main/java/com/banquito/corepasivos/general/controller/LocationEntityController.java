package com.banquito.corepasivos.general.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createLocatioEntity(@RequestBody LocationEntity locationEntity) {
        try {
            this.locationEntityService.create(locationEntity);
            ;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<LocationEntity>> getLocationEntities() {
        return ResponseEntity.ok(this.locationEntityService.findAll());
    }
    /*
     * @GetMapping(consumes = { "application/json" })
     * public ResponseEntity<Optional<Holiday>> getcountryEntityById(@RequestBody
     * String codeCountry) {
     * return ResponseEntity.ok(this.holidayService.findById(codeCountry));
     * }
     */
}

package com.banquito.corepasivos.general.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.general.model.LocationEntity;
import com.banquito.corepasivos.general.service.LocationEntityService;

@RestController
@RequestMapping("/location")
public class LocationEntityController {
    private final LocationEntityService locationEntityService;

    public LocationEntityController(LocationEntityService locationEntityService) {
        this.locationEntityService = locationEntityService;
    }

    @PostMapping
    public ResponseEntity<String> newHoliday(@RequestBody LocationEntity locationEntity) {
        try {
            this.locationEntityService.create(locationEntity);
            ;
            return ResponseEntity.ok("Location Entity created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping(consumes = { "application/json" })
    public ResponseEntity<String> updatecountryEntity(@RequestBody LocationEntity locationEntity) {
        try {
            this.locationEntityService.update(locationEntity);
            return ResponseEntity.ok("Location Entity updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping(consumes = { "application/json" })
    public ResponseEntity<String> deletecountryEntity(@RequestBody LocationEntity locationEntity) {
        try {
            this.locationEntityService.delete(locationEntity);
            return ResponseEntity.ok("Location Entity delete successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<LocationEntity>> getBankEntity() {
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

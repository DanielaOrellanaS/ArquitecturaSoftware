package com.banquito.corepasivos.general.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import com.banquito.corepasivos.general.model.CountryEntity;
import com.banquito.corepasivos.general.service.CountryEntityService;

@RestController
@RequestMapping("/api/country-entity")
public class CountryEntityController {

    private final CountryEntityService countryEntityService;

    public CountryEntityController(CountryEntityService countryEntityService) {
        this.countryEntityService = countryEntityService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<CountryEntity>> getCountryEntity() {
        return ResponseEntity.ok(this.countryEntityService.findAll());
    }

    @RequestMapping(value = "/{codeCountry}", method = RequestMethod.GET)
    public ResponseEntity<CountryEntity> findById(@PathVariable("codeCountry") String codeCountry) {
        return ResponseEntity.ok(this.countryEntityService.findById(codeCountry));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createCountry(@RequestBody CountryEntity countryEntity) {

        try {
            this.countryEntityService.create(countryEntity);
            return ResponseEntity.ok("Country Entity created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)

    public ResponseEntity<String> updateCountryEntity(@RequestBody CountryEntity countryEntity) {
        try {
            this.countryEntityService.update(countryEntity);
            return ResponseEntity.ok("Country Entity updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCountryEntity(@RequestBody CountryEntity countryEntity) {
        try {
            this.countryEntityService.delete(countryEntity);
            return ResponseEntity.ok("Country Entity delete successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}

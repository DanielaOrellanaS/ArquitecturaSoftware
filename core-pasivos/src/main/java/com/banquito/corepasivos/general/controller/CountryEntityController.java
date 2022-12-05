package com.banquito.corepasivos.general.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.general.model.CountryEntity;
import com.banquito.corepasivos.general.service.CountryEntityService;



@RestController
@RequestMapping("/countryentity")
public class CountryEntityController {
    
    private final CountryEntityService countryEntityService;

    public CountryEntityController(CountryEntityService countryEntityService){
        this.countryEntityService = countryEntityService;
    }

    @PostMapping
    public ResponseEntity<String> newEmployee(@RequestBody CountryEntity countryEntity) {
        try {
            this.countryEntityService.create(countryEntity);;
            return ResponseEntity.ok("Country Entity created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping(consumes = { "application/json" })
    public ResponseEntity<String> updatecountryEntity(@RequestBody CountryEntity countryEntity) {
        try {
            this.countryEntityService.update(countryEntity);
            return ResponseEntity.ok("Bank Entity updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping(consumes = { "application/json" })
    public ResponseEntity<String> deletecountryEntity(@RequestBody CountryEntity countryEntity) {
        try {
            this.countryEntityService.delete(countryEntity);
            return ResponseEntity.ok("Country Entity delete successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<CountryEntity>> getBankEntity() {
        return ResponseEntity.ok(this.countryEntityService.findAll());
    }

    @GetMapping(consumes = { "application/json" })
    public ResponseEntity<Optional<CountryEntity>> getcountryEntityById(@RequestBody String codeCountry) {
        return ResponseEntity.ok(this.countryEntityService.findById(codeCountry));
    }
}

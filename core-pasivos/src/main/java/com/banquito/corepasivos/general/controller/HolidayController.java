package com.banquito.corepasivos.general.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.general.model.Holiday;
import com.banquito.corepasivos.general.service.HolidayServices;

@RestController
@RequestMapping("/holiday")
public class HolidayController {
    private final HolidayServices holidayService;

    public HolidayController(HolidayServices holidayService) {
        this.holidayService = holidayService;
    }

    @PostMapping
    public ResponseEntity<String> createCountryEntity(@RequestBody Holiday holiday) {
        try {
            this.holidayService.create(holiday);
            return ResponseEntity.ok("Holiday created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping(consumes = { "application/json" })
    public ResponseEntity<String> updateCountryEntity(@RequestBody Holiday holiday) {
        try {
            this.holidayService.update(holiday);
            return ResponseEntity.ok("Holiday updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping(consumes = { "application/json" })
    public ResponseEntity<String> deleteCountryEntity(@RequestBody Holiday holiday) {
        try {
            this.holidayService.delete(holiday);
            return ResponseEntity.ok("Holiday delete successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Holiday>> getBankEntity() {
        return ResponseEntity.ok(this.holidayService.findAll());
    }

    @GetMapping("/{date}")
    public ResponseEntity<Optional<Holiday>> getCountryEntityById(@PathVariable String date) {
        return ResponseEntity.ok(this.holidayService.findById(date));
    }

}

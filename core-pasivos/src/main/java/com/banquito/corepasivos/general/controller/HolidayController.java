package com.banquito.corepasivos.general.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.general.model.Holiday;
import com.banquito.corepasivos.general.service.HolidayServices;

@RestController
@RequestMapping("/api/holiday")
public class HolidayController {
    private final HolidayServices holidayService;

    public HolidayController(HolidayServices holidayService) {
        this.holidayService = holidayService;
    }

    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Holiday>> getHolidays() {
        return ResponseEntity.ok(this.holidayService.findAll());
    }

    @RequestMapping(value = "/{date}", method = RequestMethod.PUT)
    public ResponseEntity<Optional<Holiday>> getHolidayById(@PathVariable("date") String date) {
        return ResponseEntity.ok(this.holidayService.findById(date));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createHoliday(@RequestBody Holiday holiday) {
        try {
            this.holidayService.create(holiday);
            return ResponseEntity.ok("Holiday created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{date}", method = RequestMethod.POST)
    public ResponseEntity<String> createHolidayWeekend(@PathVariable("date") Holiday dateHoliday) {
        Holiday holiday = new Holiday(); 
        if(holiday.validateWeekend(dateHoliday.getDate())){
            try {
                this.holidayService.create(dateHoliday);
                return ResponseEntity.ok("Holiday created successfully");
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(e.getMessage());
            }
        }
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<String> updateHoliday(@RequestBody Holiday holiday) {
        try {
            this.holidayService.update(holiday);
            return ResponseEntity.ok("Holiday updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteHoliday(@RequestBody Holiday holiday) {
        try {
            this.holidayService.delete(holiday);
            return ResponseEntity.ok("Holiday delete successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }



}

package com.banquito.corepasivos.general.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.banquito.corepasivos.general.service.HolidayService;

@RestController
@RequestMapping("/holiday")
public class HolidayController {
    /*@Autowired
    HolidayService holidayService;

    @GetMapping("/all")
    public Object getHoliday() {
        return this.holidayService.getAllHolidays();
    }*/
}

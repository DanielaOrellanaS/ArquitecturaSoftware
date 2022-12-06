package com.banquito.corepasivos.general.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.general.service.HolidayServices;

@RestController
@RequestMapping("/api/holiday")
public class HolidayController {
    private final HolidayServices holidayService;

    public HolidayController(HolidayServices holidayService) {
        this.holidayService = holidayService;
    }

}

package com.banquito.corepasivos.general.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.general.service.CountryEntityService;

@RestController
@RequestMapping("/countryentity")
public class CountryEntityController {
    @Autowired
    CountryEntityService countryEntityService;

    @GetMapping("/all")
    public Object getCountryEntity() {
        return this.countryEntityService.getAllCountryEntities();
    }
}

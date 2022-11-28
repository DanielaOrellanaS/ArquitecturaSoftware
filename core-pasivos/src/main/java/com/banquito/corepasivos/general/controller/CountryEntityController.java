package com.banquito.corepasivos.general.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.general.model.CountryEntity;
import com.banquito.corepasivos.general.service.CountryEntityService;

@RestController
@RequestMapping("/countryentity")
public class CountryEntityController {
    @Autowired
    private CountryEntityService countryEntityService;

    @GetMapping
    public List<CountryEntity> readCountryEntities() {
        return this.countryEntityService.readCountryEntity();
    }

    @GetMapping("/{code}")
    public CountryEntity readCountryEntity(@PathVariable("code") String code) {
        return this.countryEntityService.readCountryEntityByCode(code);
    }
}

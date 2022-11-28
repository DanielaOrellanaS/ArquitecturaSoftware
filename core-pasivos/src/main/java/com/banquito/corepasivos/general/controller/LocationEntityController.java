package com.banquito.corepasivos.general.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.general.service.LocationEntityService;

@RestController
@RequestMapping("/location")
public class LocationEntityController {
    @Autowired
    LocationEntityService locationEntityService;

    @GetMapping("/all")
    public Object getLocationEntity() {
        return this.locationEntityService.getAllLocationEntities();
    }
}

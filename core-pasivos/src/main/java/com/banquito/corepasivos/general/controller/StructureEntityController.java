package com.banquito.corepasivos.general.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.general.service.StructureEntityService;

@RestController
@RequestMapping("/structure")
public class StructureEntityController {
    @Autowired
    StructureEntityService structureEntityService;

    @GetMapping("/all")
    public Object findStructureEntity() {
        return this.structureEntityService.findAllStructureEntities();
    }
}

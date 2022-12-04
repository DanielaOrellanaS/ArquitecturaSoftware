package com.banquito.corepasivos.general.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.general.service.BankEntityService;

@RestController
@RequestMapping("/bank")
public class BankEntityController {
    @Autowired
    BankEntityService bankEntityService;

    @GetMapping("/all")
    public Object findBankEntity() {
        return this.bankEntityService.findAllBankEntities();
    }
}

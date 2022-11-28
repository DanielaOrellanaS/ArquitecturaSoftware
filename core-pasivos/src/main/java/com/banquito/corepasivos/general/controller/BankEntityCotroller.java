package com.banquito.corepasivos.general.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.general.model.BankEntity;
import com.banquito.corepasivos.general.service.BankEntityService;

@RestController
@RequestMapping("/bank/entity")
public class BankEntityCotroller {
    @Autowired
    private BankEntityService bankEntityService;

    @GetMapping
    public List<BankEntity> readBankEntities() {
        return this.bankEntityService.readAllBankEntities();
    }

    @GetMapping("/entitybankcode/{code}")
    public List<BankEntity> readBankEntityByEntityBankCode(@PathVariable("code") String code) {
        return this.bankEntityService.readEntityBankCode(code);
    }

    @GetMapping("/internationalbankcode/{code}")
    public List<BankEntity> readBankEntityByInternationalBankCode(@PathVariable("code") String code) {
        return this.bankEntityService.readInternationalBankCode(code);
    }
}

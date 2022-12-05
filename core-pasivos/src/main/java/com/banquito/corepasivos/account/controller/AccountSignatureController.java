package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.services.AccountSignatureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/signature")
public class AccountSignatureController {
    private final AccountSignatureService accountSignatureService;


    public AccountSignatureController(AccountSignatureService accountSignatureService) {
        this.accountSignatureService = accountSignatureService;
    }

    @RequestMapping("/all")
    public Object findAll() {
        return this.accountSignatureService.findAll();
    }
}

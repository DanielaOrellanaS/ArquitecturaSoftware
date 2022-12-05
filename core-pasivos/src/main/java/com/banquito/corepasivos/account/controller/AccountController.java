package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.services.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/all")
    public Object findAll() {
        return this.accountService.findAll();
    }
}

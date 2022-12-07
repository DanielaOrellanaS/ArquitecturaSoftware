package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.services.AccountClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account-client")
public class AccountClientController {
    private final AccountClientService accountClientService;

    public AccountClientController(AccountClientService accountClientService) {
        this.accountClientService = accountClientService;
    }

    @RequestMapping("/all")
    public Object findAll() {
        return this.accountClientService.findAll();
    }

}

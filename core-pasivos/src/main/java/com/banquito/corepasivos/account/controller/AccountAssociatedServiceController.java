package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.services.AccountAssociatedServiceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/associated/service")
public class AccountAssociatedServiceController {
    private final AccountAssociatedServiceService accountAssociatedServiceService;

    public AccountAssociatedServiceController(AccountAssociatedServiceService accountAssociatedServiceService) {
        this.accountAssociatedServiceService = accountAssociatedServiceService;
    }

    @RequestMapping("/all")
    public Object findAll() {
        return this.accountAssociatedServiceService.findAll();
    }

}

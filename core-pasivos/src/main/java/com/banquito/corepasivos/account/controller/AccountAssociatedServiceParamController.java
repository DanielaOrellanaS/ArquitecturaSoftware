package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.services.AccountAssociatedServiceParamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account-associated-service-param")
public class AccountAssociatedServiceParamController {
    private final AccountAssociatedServiceParamService accountAssociatedServiceParamService;


    public AccountAssociatedServiceParamController(AccountAssociatedServiceParamService accountAssociatedServiceParamService) {
        this.accountAssociatedServiceParamService = accountAssociatedServiceParamService;
    }

    @RequestMapping("/all")
    public Object findAll() {
        return this.accountAssociatedServiceParamService.findAll();
    }

}

package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.service.AccountAssociatedServiceParamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accountassociatedserviceparam")
public class AccountAssociatedServiceParamController {
    private final AccountAssociatedServiceParamService accountAssociatedServiceParamService;

    public AccountAssociatedServiceParamController(AccountAssociatedServiceParamService accountAssociatedServiceParamService){
        this.accountAssociatedServiceParamService = accountAssociatedServiceParamService;
    }

    @RequestMapping("/all")
    public Object findAllAccountAssociatedServiceParams() {
        return this.accountAssociatedServiceParamService.findAllAccountAssociatedServiceParams();
    }
}

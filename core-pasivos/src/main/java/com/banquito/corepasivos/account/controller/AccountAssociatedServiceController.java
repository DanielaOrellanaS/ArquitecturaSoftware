package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.service.AccountAssociatedServiceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accountassociatedservice")
public class AccountAssociatedServiceController {

    private final AccountAssociatedServiceService accountAssociatedServiceService;

    public AccountAssociatedServiceController(AccountAssociatedServiceService accountAssociatedServiceService){
        this.accountAssociatedServiceService= accountAssociatedServiceService;
    }

    @RequestMapping("/all")
    public Object findAllAccountAssociatedServices() {
        return this.accountAssociatedServiceService.findAllAccountAssociatedServices();
    }
}

package com.banquito.corepasivos.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.account.service.AccountAssociatedServiceService;

@RestController
@RequestMapping("/accountassociatedservice")
public class AccountAssociatedServiceController {

    @Autowired
    AccountAssociatedServiceService accountAssociatedServiceService;

    @RequestMapping("/all")
    public Object findAllAccountAssociatedServices() {
        return this.accountAssociatedServiceService.findAllAccountAssociatedServices();
    }
}

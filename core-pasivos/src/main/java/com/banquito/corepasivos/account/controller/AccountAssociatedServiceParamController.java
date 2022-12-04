package com.banquito.corepasivos.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.account.service.AccountAssociatedServiceParamService;

@RestController
@RequestMapping("accountassociatedserviceparam")
public class AccountAssociatedServiceParamController {

    @Autowired
    AccountAssociatedServiceParamService accountAssociatedServiceParamService;

    @RequestMapping("/all")
    public Object findAllAccountAssociatedServiceParams() {
        return this.accountAssociatedServiceParamService.findAllAccountAssociatedServiceParams();
    }
}

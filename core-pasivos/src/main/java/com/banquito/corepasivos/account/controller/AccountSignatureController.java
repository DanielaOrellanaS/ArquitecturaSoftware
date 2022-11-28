package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.service.AccountSignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/accountsignature")
public class AccountSignatureController {

    
    @Autowired
    AccountSignatureService accountSignatureService;

    @GetMapping("/all")
    public Object getInterest() {
        return this.accountSignatureService.getAllAccountSignatures();
    }
    
}

package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.service.AccountSignatureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/accountsignature")
public class AccountSignatureController {

    private final AccountSignatureService accountSignatureService;

    public AccountSignatureController(AccountSignatureService accountSignatureService){
        this.accountSignatureService = accountSignatureService;
    }


    @GetMapping("/all")
    public Object findAccountSignature() {
        return this.accountSignatureService.findAllAccountSignatures();
    }
    
}

package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.model.AccountSignature;
import com.banquito.corepasivos.account.services.AccountSignatureService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account-signature")
public class AccountSignatureController {
    private final AccountSignatureService accountSignatureService;


    public AccountSignatureController(AccountSignatureService accountSignatureService) {
        this.accountSignatureService = accountSignatureService;
    }

    @RequestMapping("/all")
    public Object findAll() {
        return this.accountSignatureService.findAll();
    }

    @RequestMapping(value="/{code}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountSignature>> findByCodeAccount(@PathVariable("code") String code){
       List <AccountSignature> accountSignatures = this.accountSignatureService.findByCodeAccount(code);
        if(accountSignatures.isEmpty()){
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(accountSignatures);
        }
    }
}

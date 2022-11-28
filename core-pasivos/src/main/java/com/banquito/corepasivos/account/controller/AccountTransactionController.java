package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.service.AccountTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounttransaction")
public class AccountTransactionController {

    @Autowired
    AccountTransactionService accountTransactionService;

    @GetMapping("/all")
    public Object getInterest() {
        return this.accountTransactionService.getAllAccountTransactions();
    }
}

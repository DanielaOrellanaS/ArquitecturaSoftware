package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.service.AccountTransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounttransaction")
public class AccountTransactionController {

    private final AccountTransactionService accountTransactionService;

    public AccountTransactionController(AccountTransactionService accountTransactionService) {
        this.accountTransactionService = accountTransactionService;
    }

    @GetMapping("/all")
    public Object findInterest() {
        return this.accountTransactionService.findAllAccountTransactions();
    }
}

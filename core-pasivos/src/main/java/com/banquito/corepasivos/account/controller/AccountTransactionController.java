package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.services.AccountTransactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/transaction")
public class AccountTransactionController {

    private final AccountTransactionService accountTransactionService;

    public AccountTransactionController(AccountTransactionService accountTransactionService) {
        this.accountTransactionService = accountTransactionService;
    }

    @RequestMapping("/all")
    public Object findAll() {
        return this.accountTransactionService.findAll();
    }
}

package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.model.Account;
import com.banquito.corepasivos.account.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }
}

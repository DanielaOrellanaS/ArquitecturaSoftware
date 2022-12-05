package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.model.AccountTransaction;
import com.banquito.corepasivos.account.repository.AccountTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTransactionService {

    private final AccountTransactionRepository accountTransactionRepository;

    public AccountTransactionService(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
    }

    public List<AccountTransaction> findAll(){
        return this.accountTransactionRepository.findAll();
    }
}

package com.banquito.corepasivos.account.service;

import com.banquito.corepasivos.account.model.AccountTransaction;
import com.banquito.corepasivos.account.repository.AccountTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTransactionServiceImpl implements AccountTransactionService {

    @Autowired
    AccountTransactionRepository accountTransactionRepository;

    @Override
    public List<AccountTransaction> findAllAccountTransactions(){
        return accountTransactionRepository.findAll();
    }
}

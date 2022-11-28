package com.banquito.corepasivos.account.service;

import com.banquito.corepasivos.account.model.AccountTransaction;

import java.util.List;

public interface AccountTransactionService {
    List<AccountTransaction> getAllAccountTransactions();
}

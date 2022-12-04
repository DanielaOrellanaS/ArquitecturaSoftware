package com.banquito.corepasivos.account.service;

import com.banquito.corepasivos.account.model.Account;
import com.banquito.corepasivos.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	private final AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public java.util.List<Account> findAllAccounts() {
		return accountRepository.findAll();
	}
}
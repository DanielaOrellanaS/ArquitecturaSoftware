package com.banquito.corepasivos.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.account.model.Account;
import com.banquito.corepasivos.account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository accountRepository;

	@Override
	public java.util.List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}
}
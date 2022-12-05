package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.model.AccountAssociatedService;
import com.banquito.corepasivos.account.repository.AccountAssociatedServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class AccountAssociatedServiceService {
	private final AccountAssociatedServiceRepository accountAssociatedServiceRepository;

	public AccountAssociatedServiceService(AccountAssociatedServiceRepository accountAssociatedServiceRepository) {
		this.accountAssociatedServiceRepository = accountAssociatedServiceRepository;
	}

	@Transactional
	public List<AccountAssociatedService> findByCodeLocalAccount(String codeLocalAccount) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findByCodeLocalAccount(codeLocalAccount);
		if (accountAssociatedServiceList.isEmpty()) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			return accountAssociatedServiceList;
		}
	}

	public List<AccountAssociatedService> findAll() {
		return this.accountAssociatedServiceRepository.findAll();
	}
}

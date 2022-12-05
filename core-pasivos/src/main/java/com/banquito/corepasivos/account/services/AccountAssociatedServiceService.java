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

	@Transactional
	public List<AccountAssociatedService> findByCodeInternationalAccount(String codeInternationalAccount) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findByCodeInternationalAccount(codeInternationalAccount);
		if (accountAssociatedServiceList.isEmpty()) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			return accountAssociatedServiceList;
		}
	}

	@Transactional
	public List<AccountAssociatedService> findByCodeProduct(String codeProduct) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findByCodeProduct(codeProduct);
		if (accountAssociatedServiceList.isEmpty()) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			return accountAssociatedServiceList;
		}
	}

	@Transactional
	public List<AccountAssociatedService> findByCodeProductType(String codeProductType) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findByCodeProductType(codeProductType);
		if (accountAssociatedServiceList.isEmpty()) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			return accountAssociatedServiceList;
		}
	}

	@Transactional
	public List<AccountAssociatedService> findByCodeAssociatedService(String codeAssociatedService) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findByCodeAssociatedService(codeAssociatedService);
		if (accountAssociatedServiceList.isEmpty()) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			return accountAssociatedServiceList;
		}
	}

	@Transactional
	public void deleteByCodeLocalAccount(String codeLocalAccount) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findByCodeLocalAccount(codeLocalAccount);
		if (accountAssociatedServiceList.isEmpty()) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			this.accountAssociatedServiceRepository.deleteByCodeLocalAccount(codeLocalAccount);
		}
	}

	@Transactional
	public void deleteByCodeInternationalAccount(String codeInternationalAccount) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findByCodeInternationalAccount(codeInternationalAccount);
		if (accountAssociatedServiceList.isEmpty()) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			this.accountAssociatedServiceRepository.deleteByCodeInternationalAccount(codeInternationalAccount);
		}
	}

	@Transactional
	public void deleteByCodeAssociatedService(String codeAssociatedService) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findByCodeAssociatedService(codeAssociatedService);
		if (accountAssociatedServiceList.isEmpty()) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			this.accountAssociatedServiceRepository.deleteByCodeAssociatedService(codeAssociatedService);
		}
	}

	public List<AccountAssociatedService> findAll() {
		return this.accountAssociatedServiceRepository.findAll();
	}
}

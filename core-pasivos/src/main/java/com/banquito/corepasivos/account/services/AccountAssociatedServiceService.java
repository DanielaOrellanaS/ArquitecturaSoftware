package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.model.AccountAssociatedService;
import com.banquito.corepasivos.account.repository.AccountAssociatedServiceRepository;
import com.banquito.corepasivos.account.repository.AccountRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class AccountAssociatedServiceService {
	private final AccountAssociatedServiceRepository accountAssociatedServiceRepository;

	private final AccountRepository accountRepository;

	public AccountAssociatedServiceService(AccountAssociatedServiceRepository accountAssociatedServiceRepository,
			AccountRepository accountRepository) {
		this.accountAssociatedServiceRepository = accountAssociatedServiceRepository;
		this.accountRepository = accountRepository;
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
	public void deleteAllByCodeLocalAccount(String codeLocalAccount) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findByCodeLocalAccount(codeLocalAccount);

		if (accountAssociatedServiceList.isEmpty()) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			for (AccountAssociatedService accountToUpdate : accountAssociatedServiceList) {
				accountToUpdate.setStatus("INA");
				this.accountAssociatedServiceRepository.save(accountToUpdate);
			}
		}
	}

	@Transactional
	public void deleteAllByCodeInternationalAccount(String codeInternationalAccount) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findByCodeInternationalAccount(codeInternationalAccount);
		if (accountAssociatedServiceList.isEmpty()) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			for (AccountAssociatedService accountToUpdate : accountAssociatedServiceList) {
				accountToUpdate.setStatus("INA");
				this.accountAssociatedServiceRepository.save(accountToUpdate);
			}
		}
	}

	@Transactional
	public void deleteAllByCodeAssociatedService(String codeAssociatedService) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findByCodeAssociatedService(codeAssociatedService);
		if (accountAssociatedServiceList.isEmpty()) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			for (AccountAssociatedService accountToUpdate : accountAssociatedServiceList) {
				accountToUpdate.setStatus("INA");
				this.accountAssociatedServiceRepository.save(accountToUpdate);
			}
		}
	}

	@Transactional
	public void save(AccountAssociatedService accountAssociatedService) {

		if (!accountRepository.existsByPkCodelocalaccount(accountAssociatedService.getPk().getCodelocalaccount())) {
			throw new RuntimeException("Local Account not found");
		}

		if (!accountRepository
				.existsByPkCodeinternationalaccount(accountAssociatedService.getPk().getCodeinternationalaccount())) {
			throw new RuntimeException("International Account not found");
		}

		this.accountAssociatedServiceRepository.save(accountAssociatedService);
	}

	@Transactional
	public void update(AccountAssociatedService accountAssociatedService) {
		try {
			this.accountAssociatedServiceRepository.save(accountAssociatedService);
		} catch (Exception e) {
			throw new RuntimeException("Error updating Account Associated Service");
		}
	}

	public List<AccountAssociatedService> findAll() {
		return this.accountAssociatedServiceRepository.findAll();
	}
}

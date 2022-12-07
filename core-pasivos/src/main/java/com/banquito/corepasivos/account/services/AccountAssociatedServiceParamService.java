package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.model.AccountAssociatedServiceParam;
import com.banquito.corepasivos.account.repository.AccountAssociatedServiceParamRepository;
import com.banquito.corepasivos.account.repository.AccountRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class AccountAssociatedServiceParamService {
	private final AccountAssociatedServiceParamRepository accountAssociatedServiceParamRepository;
	private final AccountRepository accountRepository;

	public AccountAssociatedServiceParamService(
			AccountAssociatedServiceParamRepository accountAssociatedServiceParamRepository,
			AccountRepository accountRepository) {
		this.accountAssociatedServiceParamRepository = accountAssociatedServiceParamRepository;
		this.accountRepository = accountRepository;
	}

	@Transactional
	public List<AccountAssociatedServiceParam> findByCodeLocalAccount(String codeLocalAccount) {
		List<AccountAssociatedServiceParam> accountAssociatedServiceParamList = this.accountAssociatedServiceParamRepository
				.findByCodeLocalAccount(codeLocalAccount);
		if (accountAssociatedServiceParamList.isEmpty()) {
			throw new RuntimeException("Account Associated Service Param not found");
		} else {
			return accountAssociatedServiceParamList;
		}
	}

	@Transactional
	public List<AccountAssociatedServiceParam> findByCodeInternationalAccount(String codeInternationalAccount) {
		List<AccountAssociatedServiceParam> accountAssociatedServiceParamList = this.accountAssociatedServiceParamRepository
				.findByCodeInternationalAccount(codeInternationalAccount);
		if (accountAssociatedServiceParamList.isEmpty()) {
			throw new RuntimeException("Account Associated Service Param not found");
		} else {
			return accountAssociatedServiceParamList;
		}
	}

	@Transactional
	public List<AccountAssociatedServiceParam> findByCodeParam(String codeParam) {
		List<AccountAssociatedServiceParam> accountAssociatedServiceParamList = this.accountAssociatedServiceParamRepository
				.findByCodeParam(codeParam);
		if (accountAssociatedServiceParamList.isEmpty()) {
			throw new RuntimeException("Account Associated Service Param not found");
		} else {
			return accountAssociatedServiceParamList;
		}
	}

	@Transactional
	public void save(AccountAssociatedServiceParam accountAssociatedServiceParam) {
		if (!accountRepository.existsByPkCodelocalaccount(accountAssociatedServiceParam.getCodeLocalAccount())) {
			throw new RuntimeException("Account not found");
		}
		if (!accountRepository
				.existsByPkCodeinternationalaccount(accountAssociatedServiceParam.getCodeInternationalAccount())) {
			throw new RuntimeException("Account not found");
		}
		this.accountAssociatedServiceParamRepository.save(accountAssociatedServiceParam);
	}

	@Transactional
	public void update(AccountAssociatedServiceParam accountAssociatedServiceParam) {
		try {
			this.accountAssociatedServiceParamRepository.save(accountAssociatedServiceParam);
		} catch (Exception e) {
			throw new RuntimeException("Error updating Account Associated Service Param");
		}
	}

	@Transactional
	public void deleteAllByCodeLocalAccount(String codeLocalAccount) {

		List<AccountAssociatedServiceParam> accountAssociatedServiceParamList = this.accountAssociatedServiceParamRepository
				.findByCodeLocalAccount(codeLocalAccount);

		if (accountAssociatedServiceParamList.isEmpty()) {
			throw new RuntimeException("Account Associated Service Param not found");
		} else {
			for (AccountAssociatedServiceParam accountAssociatedServiceParam : accountAssociatedServiceParamList) {
				accountAssociatedServiceParam.setStatus("INA");
				this.accountAssociatedServiceParamRepository.save(accountAssociatedServiceParam);
			}
		}
	}

	@Transactional
	public void deleteAllByCodeInternationalAccount(String codeInternationalAccount) {

		List<AccountAssociatedServiceParam> accountAssociatedServiceParamList = this.accountAssociatedServiceParamRepository
				.findByCodeInternationalAccount(codeInternationalAccount);

		if (accountAssociatedServiceParamList.isEmpty()) {
			throw new RuntimeException("Account Associated Service Param not found");
		} else {
			for (AccountAssociatedServiceParam accountAssociatedServiceParam : accountAssociatedServiceParamList) {
				accountAssociatedServiceParam.setStatus("INA");
				this.accountAssociatedServiceParamRepository.save(accountAssociatedServiceParam);
			}
		}
	}

	@Transactional
	public void deleteAllByCodeParam(String codeParam) {

		List<AccountAssociatedServiceParam> accountAssociatedServiceParamList = this.accountAssociatedServiceParamRepository
				.findByCodeParam(codeParam);

		if (accountAssociatedServiceParamList.isEmpty()) {
			throw new RuntimeException("Account Associated Service Param not found");
		} else {
			for (AccountAssociatedServiceParam accountAssociatedServiceParam : accountAssociatedServiceParamList) {
				accountAssociatedServiceParam.setStatus("INA");
				this.accountAssociatedServiceParamRepository.save(accountAssociatedServiceParam);
			}
		}
	}

	public List<AccountAssociatedServiceParam> findAll() {
		return accountAssociatedServiceParamRepository.findAll();
	}
}

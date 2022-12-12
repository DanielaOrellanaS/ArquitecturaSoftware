package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.dto.response.AccountAssociatedServiceResDto;
import com.banquito.corepasivos.account.mapper.AccountAssociatedServiceMapper;
import com.banquito.corepasivos.account.model.AccountAssociatedService;
import com.banquito.corepasivos.account.repository.AccountAssociatedServiceRepository;
import com.banquito.corepasivos.account.repository.AccountRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
				.findAllByCodeLocalAccount(codeLocalAccount);
		if (accountAssociatedServiceList.isEmpty()) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			return accountAssociatedServiceList;
		}
	}

	@Transactional
	public List<AccountAssociatedService> findByCodeInternationalAccount(String codeInternationalAccount) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findAllByCodeInternationalAccount(codeInternationalAccount);
		if (accountAssociatedServiceList.isEmpty()) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			return accountAssociatedServiceList;
		}
	}

	@Transactional
	public List<AccountAssociatedService> findByCodeProduct(String codeProduct) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findAllByCodeProduct(codeProduct);
		if (accountAssociatedServiceList.isEmpty()) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			return accountAssociatedServiceList;
		}
	}

	@Transactional
	public List<AccountAssociatedService> findByCodeProductType(String codeProductType) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findAllByCodeProductType(codeProductType);
		if (accountAssociatedServiceList.isEmpty()) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			return accountAssociatedServiceList;
		}
	}

	@Transactional
	public List<AccountAssociatedService> findByCodeAssociatedService(String codeAssociatedService) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findAllByCodeAssociatedService(codeAssociatedService);
		if (accountAssociatedServiceList.isEmpty()) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			return accountAssociatedServiceList;
		}
	}

	@Transactional
	public void deleteAllByCodeLocalAccount(String codeLocalAccount) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findAllByCodeLocalAccount(codeLocalAccount);

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
				.findAllByCodeInternationalAccount(codeInternationalAccount);
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
				.findAllByCodeAssociatedService(codeAssociatedService);
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
	public void deleteByCodeAssociatedService(String codeAssociatedService, String codeLocalAccount) {
		AccountAssociatedService accountAssociatedService = this.accountAssociatedServiceRepository
				.findByCodeAssociatedServiceAndCodeLocalAccount(codeAssociatedService, codeLocalAccount);

		if (accountAssociatedService == null) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			accountAssociatedService.setStatus("INA");
			this.accountAssociatedServiceRepository.save(accountAssociatedService);
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

	public List<AccountAssociatedServiceResDto> findAll() {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository.findAll();
		List<AccountAssociatedServiceResDto> listDto = new ArrayList<>();
		AccountAssociatedServiceResDto serviceDto;

		for (AccountAssociatedService service : accountAssociatedServiceList) {
			serviceDto = AccountAssociatedServiceMapper.mapper(service);
			listDto.add(serviceDto);
		}

		return listDto;
	}

	public List<AccountAssociatedServiceResDto> findByCodeLocalAccountAndCodeInternationalAccount(
			String codeLocalAccount, String codeInternationalAccount) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findAllByCodeLocalAccountAndCodeInternationalAccount(codeLocalAccount, codeInternationalAccount);
		List<AccountAssociatedServiceResDto> listDto = new ArrayList<>();
		AccountAssociatedServiceResDto serviceDto;

		for (AccountAssociatedService service : accountAssociatedServiceList) {
			serviceDto = AccountAssociatedServiceMapper.mapper(service);
			serviceDto.setCodeProduct(service.getCodeProduct());
			serviceDto.setCodeProductType(service.getCodeProductType());
			serviceDto.setCodeAssociatedService(service.getCodeAssociatedService());
			serviceDto.setStatus(service.getStatus());
			serviceDto.setStartDate(service.getStartDate());
			serviceDto.setEndDate(service.getEndDate());
			listDto.add(serviceDto);
		}

		return listDto;
	}

}

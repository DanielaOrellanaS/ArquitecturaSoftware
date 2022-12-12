package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.dto.request.AccountAssociatedServiceReqDto;
import com.banquito.corepasivos.account.dto.response.AccountAssociatedServiceResDto;
import com.banquito.corepasivos.account.mapper.AccountAssociatedServiceMapper;
import com.banquito.corepasivos.account.model.AccountAssociatedService;
import com.banquito.corepasivos.account.model.AccountAssociatedServicePK;
import com.banquito.corepasivos.account.repository.AccountAssociatedServiceRepository;
import com.banquito.corepasivos.account.repository.AccountRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

	@Transactional
	public List<AccountAssociatedServiceResDto> findByCodeLocalAccountAndCodeInternationalAccountAndStatus(
			String codeLocalAccount, String codeInternationalAccount, String status) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findAllByCodeLocalAccountAndCodeInternationalAccountAndStatus(codeLocalAccount,
						codeInternationalAccount,
						status);
		List<AccountAssociatedServiceResDto> listDto = new ArrayList<>();
		AccountAssociatedServiceResDto serviceDto;

		for (AccountAssociatedService service : accountAssociatedServiceList) {
			serviceDto = AccountAssociatedServiceMapper.mapper(service);
			serviceDto.setCodeProduct(service.getCodeProduct());
			serviceDto.setCodeProductType(service.getCodeProductType());
			serviceDto.setCodeAssociatedService(service.getCodeAssociatedService());
			serviceDto.setStartDate(service.getStartDate());
			serviceDto.setEndDate(service.getEndDate());
			listDto.add(serviceDto);
		}

		return listDto;
	}

	@Transactional
	public void deleteAllByLocalInternationalCodeAccount(String codeLocalAccount, String codeInternationalAccount) {
		List<AccountAssociatedService> accountAssociatedServiceList = this.accountAssociatedServiceRepository
				.findAllByCodeLocalAccountAndCodeInternationalAccount(codeLocalAccount, codeInternationalAccount);
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
	public void deleteByLocalInternationalCodeAccountAndCodeAssociatedService(String codeLocalAccount,
			String codeInternationalAccount, String codeAssociatedService) {
		AccountAssociatedService accountAssociatedService = this.accountAssociatedServiceRepository
				.findByCodeLocalAccountAndCodeInternationalAccountAndCodeAssociatedService(codeLocalAccount,
						codeInternationalAccount, codeAssociatedService);
		if (accountAssociatedService == null) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			accountAssociatedService.setStatus("INA");
			this.accountAssociatedServiceRepository.save(accountAssociatedService);
		}
	}

	@Transactional
	public void save(AccountAssociatedServiceReqDto accountAssociatedServiceReqDto) {

		if (!accountRepository
				.existsByPkCodelocalaccount(accountAssociatedServiceReqDto.getCodeLocalAccount())) {
			throw new RuntimeException("Local Account not found");
		}

		if (!accountRepository
				.existsByPkCodeinternationalaccount(
						accountAssociatedServiceReqDto.getCodeInternationalAccount())) {
			throw new RuntimeException("International Account not found");
		}

		AccountAssociatedService accountAssociatedService = new AccountAssociatedService();
		AccountAssociatedServicePK pk = new AccountAssociatedServicePK();

		pk.setCodelocalaccount(accountAssociatedServiceReqDto.getCodeLocalAccount());
		pk.setCodeinternationalaccount(accountAssociatedServiceReqDto.getCodeInternationalAccount());
		pk.setCodeproduct(accountAssociatedServiceReqDto.getCodeProduct());
		pk.setCodeproducttype(accountAssociatedServiceReqDto.getCodeProductType());

		accountAssociatedService.setPk(pk);

		accountAssociatedService.setCodeAssociatedService(accountAssociatedServiceReqDto.getCodeAssociatedService());

		accountAssociatedService.setStatus("ACT");

		accountAssociatedService.setStartDate(new Date());

		accountAssociatedService.setEndDate(null);

		this.accountAssociatedServiceRepository.save(accountAssociatedService);

	}

	@Transactional
	public void update(
			AccountAssociatedServiceReqDto accountAssociatedServiceReqDto) {

		if (!accountRepository
				.existsByPkCodelocalaccount(accountAssociatedServiceReqDto.getCodeLocalAccount())) {
			throw new RuntimeException("Local Account not found");
		}

		if (!accountRepository
				.existsByPkCodeinternationalaccount(
						accountAssociatedServiceReqDto.getCodeInternationalAccount())) {
			throw new RuntimeException("International Account not found");
		}

		AccountAssociatedService accountAssociatedService = this.accountAssociatedServiceRepository
				.findByCodeLocalAccountAndCodeInternationalAccountAndCodeAssociatedService(
						accountAssociatedServiceReqDto.getCodeLocalAccount(),
						accountAssociatedServiceReqDto.getCodeInternationalAccount(),
						accountAssociatedServiceReqDto.getCodeAssociatedService());

		if (accountAssociatedService == null) {
			throw new RuntimeException("Account Associated Service not found");
		} else {
			accountAssociatedService
					.setCodeAssociatedService(accountAssociatedServiceReqDto.getCodeAssociatedService());

			accountAssociatedService.setCodeProduct(accountAssociatedServiceReqDto.getCodeProduct());

			accountAssociatedService.setCodeProductType(accountAssociatedServiceReqDto.getCodeProductType());

			this.accountAssociatedServiceRepository.save(accountAssociatedService);
		}
	}
}

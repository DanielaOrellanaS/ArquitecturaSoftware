package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.dto.response.AccountTransactionRecipientBankResDto;
import com.banquito.corepasivos.account.dto.response.AccountTransactionResDto;
import com.banquito.corepasivos.account.dto.response.AccountTransactionStatusResDto;
import com.banquito.corepasivos.account.dto.response.AccountTransactionUniqueResDto;
import com.banquito.corepasivos.account.mapper.AccountTransactionMapper;

import com.banquito.corepasivos.account.model.Account;
import com.banquito.corepasivos.account.model.AccountTransaction;
import com.banquito.corepasivos.account.repository.AccountRepository;
import com.banquito.corepasivos.account.repository.AccountTransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Random;

import javax.transaction.Transactional;

@Service
public class AccountTransactionService {

	private final AccountTransactionRepository accountTransactionRepository;
	private final AccountRepository accountRepository;

	public AccountTransactionService(AccountTransactionRepository accountTransactionRepository,
			AccountRepository accountRepository) {
		this.accountTransactionRepository = accountTransactionRepository;
		this.accountRepository = accountRepository;
	}

	@Transactional
	public void saveTransactionDeb(AccountTransaction transaction) {

		/*if (transaction.getCodeLocalAccount() != null) {
			if (this.accountRepository.existsByPkCodelocalaccount(transaction.getCodeLocalAccount().toLowerCase())) {
				List<Account> accountList = this.accountRepository
						.findByPkCodelocalaccountAndPkCodeinternationalaccount(
								transaction.getCodeLocalAccount(), transaction.getCodeInternationalAccount());
				Account accountOpt = accountList.get(0);

				transaction.setCodeInternationalAccount(accountOpt.getPk().getCodeinternationalaccount());
				transaction.setCodeUniqueTransaction(randomHex());
				transaction.setCreateDate(new Date());
				transaction.setStatus("ACT");

				if (transaction.getType().toUpperCase().equals("DEB")
						&& transaction.getRecipientType().toUpperCase().equals("BEN")) {
					if (accountOpt.getAvailableBalance().compareTo(transaction.getValue()) == 1) {
						accountOpt.setAvailableBalance(new BigDecimal(
								accountOpt.getAvailableBalance().doubleValue() - transaction.getValue().doubleValue(),
								MathContext.DECIMAL32));

						accountOpt.setPresentBalance(new BigDecimal(
								accountOpt.getPresentBalance().doubleValue() - transaction.getValue().doubleValue(),
								MathContext.DECIMAL32));
						this.accountRepository.save(accountOpt);

					} else {
						throw new RuntimeException("You dont have founds");
					}
				} else if (transaction.getType().toUpperCase().equals("CRE")
						&& transaction.getRecipientType().toUpperCase().equals("PAY")) {
					accountOpt.setAvailableBalance(new BigDecimal(
							accountOpt.getAvailableBalance().doubleValue() + transaction.getValue().doubleValue(),
							MathContext.DECIMAL32));

					accountOpt.setPresentBalance(new BigDecimal(
							accountOpt.getPresentBalance().doubleValue() + transaction.getValue().doubleValue(),
							MathContext.DECIMAL32));
					this.accountRepository.save(accountOpt);

				}

				this.accountTransactionRepository.save(transaction);

			} else {
				throw new RuntimeException("Account doesnt exits");
			}

		} else {
			throw new RuntimeException("Please set an account code");
		}*/
	}

	public String randomHex() {
		char[] charArr = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		Random rand = new Random();
		String result = "";
		for (int x = 0; x < 64; x++) {
			int resInt = rand.nextInt(charArr.length);// random array element
			result += charArr[resInt];
		}

		return result;
	}

	public List<AccountTransactionResDto> findByCodeLocalAccountAndCodeInternationalAccount(String codeLocalAccount,
			String codeInternationalAccount) {
		List<AccountTransaction> accountTransactionList = this.accountTransactionRepository
				.findAllByCodeLocalAccountAndCodeInternationalAccount(codeLocalAccount, codeInternationalAccount);
		List<AccountTransactionResDto> listDto = new ArrayList<>();
		AccountTransactionResDto serviceDto;

		for (AccountTransaction service : accountTransactionList) {
			serviceDto = AccountTransactionMapper.mapper(service);
			serviceDto.setCodeUniqueTransaction(service.getCodeUniqueTransaction());
			serviceDto.setType(service.getType());
			serviceDto.setRecipientAccountNumber(service.getRecipientAccountNumber());
			serviceDto.setRecipientType(service.getRecipientType());
			serviceDto.setRecipientBank(service.getRecipientBank());
			serviceDto.setReference(service.getReference());
			serviceDto.setDescription(service.getDescription());
			serviceDto.setValue(service.getValue());
			serviceDto.setCreateDate(service.getCreateDate());
			serviceDto.setExecuteDate(service.getExecuteDate());
			serviceDto.setStatus(service.getStatus());
			listDto.add(serviceDto);
		}

		return listDto;
	}

	public List<AccountTransactionResDto> findByExecuteDateBetween(String codeLocalAccount,
			String codeInternationalAccount, Date start, Date end) {

		List<AccountTransaction> accountTransactionList = this.accountTransactionRepository
				.findByExecuteDateBetween(start, end);
		List<AccountTransactionResDto> listDto = new ArrayList<>();
		AccountTransactionResDto serviceDto;

		for (AccountTransaction service : accountTransactionList) {
			serviceDto = AccountTransactionMapper.mapper(service);
			serviceDto.setCodeUniqueTransaction(service.getCodeUniqueTransaction());
			serviceDto.setType(service.getType());
			serviceDto.setRecipientAccountNumber(service.getRecipientAccountNumber());
			serviceDto.setRecipientType(service.getRecipientType());
			serviceDto.setRecipientBank(service.getRecipientBank());
			serviceDto.setReference(service.getReference());
			serviceDto.setDescription(service.getDescription());
			serviceDto.setValue(service.getValue());
			serviceDto.setCreateDate(service.getCreateDate());
			serviceDto.setExecuteDate(service.getExecuteDate());
			serviceDto.setStatus(service.getStatus());
			listDto.add(serviceDto);
		}

		return listDto;
	}

	public List<AccountTransactionResDto> findByCodeLocalAccountAndCodeInternationalAccountAndType(
			String codeLocalAccount, String codeInternationalAccount, String type) {
		List<AccountTransaction> accountTransactionList = this.accountTransactionRepository
				.findAllByCodeLocalAccountAndCodeInternationalAccountAndType(codeLocalAccount, codeInternationalAccount,
						type.toUpperCase());
		List<AccountTransactionResDto> listDto = new ArrayList<>();
		AccountTransactionResDto serviceDto;

		for (AccountTransaction service : accountTransactionList) {
			serviceDto = AccountTransactionMapper.mapper(service);
			serviceDto.setCodeUniqueTransaction(service.getCodeUniqueTransaction());
			serviceDto.setType(service.getType());
			serviceDto.setRecipientAccountNumber(service.getRecipientAccountNumber());
			serviceDto.setRecipientType(service.getRecipientType());
			serviceDto.setRecipientBank(service.getRecipientBank());
			serviceDto.setReference(service.getReference());
			serviceDto.setDescription(service.getDescription());
			serviceDto.setValue(service.getValue());
			serviceDto.setCreateDate(service.getCreateDate());
			serviceDto.setExecuteDate(service.getExecuteDate());
			serviceDto.setStatus(service.getStatus());
			listDto.add(serviceDto);
		}

		return listDto;
	}

	public List<AccountTransactionRecipientBankResDto> findByCodeLocalAccountAndCodeInternationalAccountAndRecipientBank(
			String codeLocalAccount, String codeInternationalAccount, String recipientBank) {
		List<AccountTransaction> accountTransactionList = this.accountTransactionRepository
				.findAllByCodeLocalAccountAndCodeInternationalAccountAndRecipientBank(codeLocalAccount,
						codeInternationalAccount, recipientBank);
		List<AccountTransactionRecipientBankResDto> listDto = new ArrayList<>();
		AccountTransactionRecipientBankResDto serviceDto;

		for (AccountTransaction service : accountTransactionList) {
			serviceDto = AccountTransactionMapper.mapperRecipientBanl(service);
			serviceDto.setCodeUniqueTransaction(service.getCodeUniqueTransaction());
			serviceDto.setType(service.getType());
			serviceDto.setRecipientAccountNumber(service.getRecipientAccountNumber());
			serviceDto.setRecipientType(service.getRecipientType());
			serviceDto.setReference(service.getReference());
			serviceDto.setDescription(service.getDescription());
			serviceDto.setValue(service.getValue());
			serviceDto.setCreateDate(service.getCreateDate());
			serviceDto.setExecuteDate(service.getExecuteDate());
			serviceDto.setStatus(service.getStatus());
			listDto.add(serviceDto);
		}

		return listDto;
	}

	public List<AccountTransactionStatusResDto> findByCodeLocalAccountAndCodeInternationalAccountAndStatus(
			String codeLocalAccount, String codeInternationalAccount, String status) {
		List<AccountTransaction> accountTransactionList = this.accountTransactionRepository
				.findAllByCodeLocalAccountAndCodeInternationalAccountAndStatus(codeLocalAccount,
						codeInternationalAccount, status.toUpperCase());
		List<AccountTransactionStatusResDto> listDto = new ArrayList<>();
		AccountTransactionStatusResDto serviceDto;

		for (AccountTransaction service : accountTransactionList) {
			serviceDto = AccountTransactionMapper.mapperStatus(service);
			serviceDto.setCodeUniqueTransaction(service.getCodeUniqueTransaction());
			serviceDto.setType(service.getType());
			serviceDto.setRecipientAccountNumber(service.getRecipientAccountNumber());
			serviceDto.setRecipientType(service.getRecipientType());
			serviceDto.setReference(service.getReference());
			serviceDto.setDescription(service.getDescription());
			serviceDto.setValue(service.getValue());
			serviceDto.setCreateDate(service.getCreateDate());
			serviceDto.setExecuteDate(service.getExecuteDate());

			listDto.add(serviceDto);
		}

		return listDto;
	}

	public List<AccountTransactionUniqueResDto> findByCodeUniqueTransaction(String codeUniqueTransaction) {
		List<AccountTransaction> accountTransactionList = this.accountTransactionRepository
				.findByCodeUniqueTransaction(codeUniqueTransaction);
		List<AccountTransactionUniqueResDto> listDto = new ArrayList<>();
		AccountTransactionUniqueResDto serviceDto;

		for (AccountTransaction service : accountTransactionList) {
			serviceDto = AccountTransactionMapper.mapperUniqueCode(service);
			serviceDto.setCodeLocalAccount(service.getCodeLocalAccount());
			serviceDto.setCodeInternationalAccount(service.getCodeInternationalAccount());
			serviceDto.setType(service.getType());
			serviceDto.setRecipientAccountNumber(service.getRecipientAccountNumber());
			serviceDto.setRecipientType(service.getRecipientType());
			serviceDto.setRecipientBank(service.getRecipientBank());
			serviceDto.setReference(service.getReference());
			serviceDto.setDescription(service.getDescription());
			serviceDto.setValue(service.getValue());
			serviceDto.setCreateDate(service.getCreateDate());
			serviceDto.setExecuteDate(service.getExecuteDate());
			serviceDto.setStatus(service.getStatus());
			listDto.add(serviceDto);
		}

		return listDto;
	}

}

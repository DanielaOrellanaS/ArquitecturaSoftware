package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.model.Account;
import com.banquito.corepasivos.account.model.AccountTransaction;
import com.banquito.corepasivos.account.repository.AccountRepository;
import com.banquito.corepasivos.account.repository.AccountTransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
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

	public List<AccountTransaction> findAll() {
		return this.accountTransactionRepository.findAll();
	}

	
	@Transactional
	public void saveTransactionDeb(AccountTransaction transaction) {
		
		if(transaction.getCodeLocalAccount() !=null){
			List<Account> accountList = this.accountRepository
				.findByPkCodelocalaccount(transaction.getCodeLocalAccount().toLowerCase());
			if (accountList.size() > 0) {
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

		}else{
			throw new RuntimeException("Please set an account code");
		}
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

	
	public List<AccountTransaction> findByCodeLocalAccount(String codeLocalAccount) {
		List<AccountTransaction> accountTransaction = this.accountTransactionRepository
				.findByCodeLocalAccount(codeLocalAccount);
		if (accountTransaction.isEmpty()) {
			throw new RuntimeException("Account Transaction by Account not found");
		} else {
			return accountTransaction;
		}
	}

	public List<AccountTransaction> findByCodeUniqueTransaction(String codeUniqueTransaction) {
		List<AccountTransaction> accountTransaction = this.accountTransactionRepository
				.findByCodeUniqueTransaction(codeUniqueTransaction);
		if (accountTransaction.isEmpty()) {
			throw new RuntimeException("Account Transaction not found");
		} else {
			return accountTransaction;
		}
	}

	public List<AccountTransaction> findByStatus(String status) {
		List<AccountTransaction> accountTransaction = this.accountTransactionRepository
				.findByStatus(status);
		if (accountTransaction.isEmpty()) {
			throw new RuntimeException("Account not found");
		} else {
			return accountTransaction;
		}
	}

	public List<AccountTransaction> findByRecipientBank(String recipientBank) {
		List<AccountTransaction> accountTransaction = this.accountTransactionRepository
				.findByRecipientBank(recipientBank);
		if (accountTransaction.isEmpty()) {
			throw new RuntimeException("Account Transaction by Recipient Bank not found");
		} else {
			return accountTransaction;
		}
	}

	// public List<AccountTransaction> findByDate(Date start, Date end) {
	// List<AccountTransaction> accountTransaction =
	// this.accountTransactionRepository
	// .findByDate(start, end);
	// if (accountTransaction.isEmpty()) {
	// throw new RuntimeException("Account Transaction by Date not found");
	// } else {
	// return accountTransaction;
	// }
	// }
}

package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.model.AccountTransaction;
import com.banquito.corepasivos.account.repository.AccountTransactionRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AccountTransactionService {

    private final AccountTransactionRepository accountTransactionRepository;

    public AccountTransactionService(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
    }

    public List<AccountTransaction> findAll(){
        return this.accountTransactionRepository.findAll();
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
	// 	List<AccountTransaction> accountTransaction = this.accountTransactionRepository
	// 			.findByDate(start, end);
	// 	if (accountTransaction.isEmpty()) {
	// 		throw new RuntimeException("Account Transaction by Date not found");
	// 	} else {
	// 		return accountTransaction;
	// 	}
	// }
}

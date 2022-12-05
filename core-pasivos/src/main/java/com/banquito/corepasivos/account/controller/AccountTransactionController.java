package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.model.AccountTransaction;
import com.banquito.corepasivos.account.services.AccountTransactionService;

import java.util.List;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/transaction")
public class AccountTransactionController {

    private final AccountTransactionService accountTransactionService;

    public AccountTransactionController(AccountTransactionService accountTransactionService) {
        this.accountTransactionService = accountTransactionService;
    }

    @RequestMapping("/all")
    public Object findAll() {
        return this.accountTransactionService.findAll();
    }

    
    @RequestMapping("/LocalAccount/{codeLocalAccount}")
	public ResponseEntity<List<AccountTransaction>> findByCodeLocalAccount(
			@PathVariable("codeLocalAccount") String codeLocalAccount) {

		List<AccountTransaction> accountTransactionService = this.accountTransactionService
				.findByCodeLocalAccount(codeLocalAccount);
		if (accountTransactionService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountTransactionService);
		}

	}

    @RequestMapping("/CodeUniqueTransaction/{codeUniqueTransaction}")
	public ResponseEntity<List<AccountTransaction>> findByCodeUniqueTransaction(
			@PathVariable("codeUniqueTransaction") String codeUniqueTransaction) {

		List<AccountTransaction> accountTransactionService = this.accountTransactionService
				.findByCodeUniqueTransaction(codeUniqueTransaction);
		if (accountTransactionService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountTransactionService);
		}

	}

    @RequestMapping("/Status/{status}")
	public ResponseEntity<List<AccountTransaction>> findByStatus(
			@PathVariable("status") String status) {

		List<AccountTransaction> accountTransactionService = this.accountTransactionService
				.findByStatus(status);
		if (accountTransactionService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountTransactionService);
		}

	}

    @RequestMapping("/RecipientBank/{recipientBank}")
	public ResponseEntity<List<AccountTransaction>> findByRecipientBank(
			@PathVariable("recipientBank") String recipientBank) {

		List<AccountTransaction> accountTransactionService = this.accountTransactionService
				.findByRecipientBank(recipientBank);
		if (accountTransactionService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountTransactionService);
		}

	}

    // @RequestMapping("/findByDate/{recipientBank}")
	// public ResponseEntity<List<AccountTransaction>> findByRecipientBank(
	// 		@PathVariable("recipientBank") String recipientBank) {

	// 	List<AccountTransaction> accountTransactionService = this.accountTransactionService
	// 			.findByRecipientBank(recipientBank);
	// 	if (accountTransactionService.isEmpty()) {
	// 		return ResponseEntity.notFound().build();
	// 	} else {
	// 		return ResponseEntity.ok(accountTransactionService);
	// 	}

	// }

    



}

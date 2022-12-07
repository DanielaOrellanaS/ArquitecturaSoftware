package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.model.AccountTransaction;
import com.banquito.corepasivos.account.services.AccountTransactionService;

import java.util.List;

import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account-transaction")
public class AccountTransactionController {

    private final AccountTransactionService accountTransactionService;

    public AccountTransactionController(AccountTransactionService accountTransactionService) {
        this.accountTransactionService = accountTransactionService;
    }


	@RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createTransaction(@RequestBody AccountTransaction transaction) {
        try {
            this.accountTransactionService.saveTransactionDeb(transaction);
            return ResponseEntity.ok("Transaction saved"+transaction.getCodeUniqueTransaction());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

	@RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity <List<AccountTransaction>> findAll() {
        List<AccountTransaction> transaction = this.accountTransactionService.findAll();

		if(transaction.isEmpty()){
			return ResponseEntity.notFound().build();
		}else{
			return ResponseEntity.ok(transaction);
		}
    }

    
    @RequestMapping("/local-account/{codeLocalAccount}")
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

    // @RequestMapping("/code-transaction/{codeUniqueTransaction}")
	// public ResponseEntity<List<AccountTransaction>> findByCodeUniqueTransaction(
	// 		@PathVariable("codeUniqueTransaction") String codeUniqueTransaction) {

	// 	List<AccountTransaction> accountTransactionService = this.accountTransactionService
	// 			.findByCodeUniqueTransaction(codeUniqueTransaction);
	// 	if (accountTransactionService.isEmpty()) {
	// 		return ResponseEntity.notFound().build();
	// 	} else {
	// 		return ResponseEntity.ok(accountTransactionService);
	// 	}

	// }

    @RequestMapping("/status/{status}")
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

    @RequestMapping("/recipient-bank/{recipientBank}")
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

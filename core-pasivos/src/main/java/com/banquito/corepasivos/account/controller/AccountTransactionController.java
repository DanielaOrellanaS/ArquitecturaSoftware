package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.dto.response.AccountTransactionRecipientBankResDto;
import com.banquito.corepasivos.account.dto.response.AccountTransactionResDto;
import com.banquito.corepasivos.account.dto.response.AccountTransactionStatusResDto;
import com.banquito.corepasivos.account.dto.response.AccountTransactionUniqueResDto;
import com.banquito.corepasivos.account.model.AccountTransaction;
import com.banquito.corepasivos.account.services.AccountTransactionService;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
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

	@RequestMapping(value = "/local/{codeLocalAccount}/international/{codeInternationalAccount}",method = RequestMethod.GET)
	public ResponseEntity<List<AccountTransactionResDto>> findByCodeLocalAccountAndInternationalAccount(
			@PathVariable("codeLocalAccount") String codeLocalAccount,
			@PathVariable("codeInternationalAccount") String codeInternationalAccount) {

		List<AccountTransactionResDto> accountTransactionService = this.accountTransactionService.findByCodeLocalAccountAndCodeInternationalAccount(codeLocalAccount, codeInternationalAccount);
				
		if (accountTransactionService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountTransactionService);
		}

	}

	@RequestMapping(value = "/	/{codeUniqueTransaction}",method = RequestMethod.GET)
	public ResponseEntity<List<AccountTransactionUniqueResDto>> findByCodeUniqueTransaction(
			@PathVariable("codeUniqueTransaction") String codeUniqueTransaction) {

		List<AccountTransactionUniqueResDto> accountTransactionService = this.accountTransactionService
				.findByCodeUniqueTransaction(codeUniqueTransaction.toLowerCase());
		if (accountTransactionService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountTransactionService);
		}

	}

	@RequestMapping(value = "/local/{codeLocalAccount}/international/{codeInternationalAccount}/type/{type}",method = RequestMethod.GET)
	public ResponseEntity<List<AccountTransactionResDto>> findByCodeLocalAccountAndInternationalAccountType(
			@PathVariable("codeLocalAccount") String codeLocalAccount,
			@PathVariable("codeInternationalAccount") String codeInternationalAccount,
			@PathVariable("type") String type) {

		List<AccountTransactionResDto> accountTransactionService = this.accountTransactionService.findByCodeLocalAccountAndCodeInternationalAccountAndType(codeLocalAccount, codeInternationalAccount,type.toUpperCase());
				
		if (accountTransactionService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountTransactionService);
		}

	}

	@RequestMapping(value = "/local/{codeLocalAccount}/international/{codeInternationalAccount}/recipient-bank/{recipientBank}",method = RequestMethod.GET)
	public ResponseEntity<List<AccountTransactionRecipientBankResDto>> findByCodeLocalAccountAndInternationalAccountRecipientBank(
			@PathVariable("codeLocalAccount") String codeLocalAccount,
			@PathVariable("codeInternationalAccount") String codeInternationalAccount,
			@PathVariable("recipientBank") String recipientBank) {

		List<AccountTransactionRecipientBankResDto> accountTransactionService = this.accountTransactionService.findByCodeLocalAccountAndCodeInternationalAccountAndRecipientBank(codeLocalAccount, codeInternationalAccount,recipientBank.toUpperCase());
				
		if (accountTransactionService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountTransactionService);
		}

	}

	@RequestMapping(value = "/local/{codeLocalAccount}/international/{codeInternationalAccount}/status/{status}",method = RequestMethod.GET)
	public ResponseEntity<List<AccountTransactionStatusResDto>> findByCodeLocalAccountAndInternationalAccountStatus(
			@PathVariable("codeLocalAccount") String codeLocalAccount,
			@PathVariable("codeInternationalAccount") String codeInternationalAccount,
			@PathVariable("status") String status) {

		List<AccountTransactionStatusResDto> accountTransactionService = this.accountTransactionService.findByCodeLocalAccountAndCodeInternationalAccountAndStatus(codeLocalAccount, codeInternationalAccount,status.toUpperCase());
				
		if (accountTransactionService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountTransactionService);
		}

	}

	@RequestMapping(value = "/local/{codeLocalAccount}/international/{codeInternationalAccount}/range-date/{start}/{end}",method = RequestMethod.GET)
	public ResponseEntity<List<AccountTransactionResDto>> findByRangeDate(
		@PathVariable("codeLocalAccount") String codeLocalAccount,
			@PathVariable("codeInternationalAccount") String codeInternationalAccount,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")Date start,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {

		List<AccountTransactionResDto> accountTransactionService = this.accountTransactionService
				.findByExecuteDateBetween(codeLocalAccount,codeInternationalAccount, start, end);
		if (accountTransactionService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountTransactionService);
		}

	}

	

	

	

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> createTransaction(@RequestBody AccountTransaction transaction) {

		try {
			this.accountTransactionService.saveTransactionDeb(transaction);
			return ResponseEntity.ok("Transaction saved");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

}

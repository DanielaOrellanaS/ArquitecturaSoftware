package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.model.AccountAssociatedService;
import com.banquito.corepasivos.account.services.AccountAssociatedServiceService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/associated/service")
public class AccountAssociatedServiceController {
	private final AccountAssociatedServiceService service;

	public AccountAssociatedServiceController(AccountAssociatedServiceService service) {
		this.service = service;
	}

	@GetMapping("/local/{codeLocalAccount}")
	public ResponseEntity<List<AccountAssociatedService>> findByCodeLocalAccount(
			@PathVariable("codeLocalAccount") String codeLocalAccount) {

		List<AccountAssociatedService> accountAssociatedService = this.service
				.findByCodeLocalAccount(codeLocalAccount);
		if (accountAssociatedService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountAssociatedService);
		}

	}

	@RequestMapping("/all")
	public Object findAll() {
		return this.service.findAll();
	}

}

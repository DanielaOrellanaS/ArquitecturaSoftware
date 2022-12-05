package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.model.AccountAssociatedService;
import com.banquito.corepasivos.account.services.AccountAssociatedServiceService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accountAssociatedService")
public class AccountAssociatedServiceController {
	private final AccountAssociatedServiceService service;

	public AccountAssociatedServiceController(AccountAssociatedServiceService service) {
		this.service = service;
	}

	@RequestMapping(value = "/findByCodeLocalAccount/{codeLocalAccount}", method = RequestMethod.GET)
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

	@RequestMapping(value = "/findByCodeInternationalAccount/{codeInternationalAccount}", method = RequestMethod.GET)
	public ResponseEntity<List<AccountAssociatedService>> findByCodeInternationalAccount(
			@PathVariable("codeInternationalAccount") String codeInternationalAccount) {

		List<AccountAssociatedService> accountAssociatedService = this.service
				.findByCodeInternationalAccount(codeInternationalAccount);
		if (accountAssociatedService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountAssociatedService);
		}

	}

	@RequestMapping(value = "/findByCodeProduct/{codeProduct}", method = RequestMethod.GET)
	public ResponseEntity<List<AccountAssociatedService>> findByCodeProduct(
			@PathVariable("codeProduct") String codeProduct) {

		List<AccountAssociatedService> accountAssociatedService = this.service.findByCodeProduct(codeProduct);
		if (accountAssociatedService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountAssociatedService);
		}

	}

	@RequestMapping(value = "/findByCodeProductType/{codeProductType}", method = RequestMethod.GET)
	public ResponseEntity<List<AccountAssociatedService>> findByCodeProductType(
			@PathVariable("codeProductType") String codeProductType) {

		List<AccountAssociatedService> accountAssociatedService = this.service.findByCodeProductType(codeProductType);
		if (accountAssociatedService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountAssociatedService);
		}

	}

	@RequestMapping(value = "/findByCodeAssociatedService/{codeAssociatedService}", method = RequestMethod.GET)
	public ResponseEntity<List<AccountAssociatedService>> findByCodeAssociatedService(
			@PathVariable("codeAssociatedService") String codeAssociatedService) {

		List<AccountAssociatedService> accountAssociatedService = this.service
				.findByCodeAssociatedService(codeAssociatedService);
		if (accountAssociatedService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountAssociatedService);
		}

	}

	@RequestMapping(value = "/deleteByCodeLocalAccount/{codeLocalAccount}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteByCodeLocalAccount(
			@PathVariable("codeLocalAccount") String codeLocalAccount) {

		try {
			this.service.deleteAllByCodeLocalAccount(codeLocalAccount);
			return ResponseEntity.ok("OK");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@RequestMapping(value = "/deleteByCodeInternationalAccount/{codeInternationalAccount}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteByCodeInternationalAccount(
			@PathVariable("codeInternationalAccount") String codeInternationalAccount) {

		try {
			this.service.deleteAllByCodeInternationalAccount(codeInternationalAccount);
			return ResponseEntity.ok("OK");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@RequestMapping(value = "/deleteByCodeAssociatedService/{codeAssociatedService}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteByCodeAssociatedService(
			@PathVariable("codeAssociatedService") String codeAssociatedService) {

		try {
			this.service.deleteAllByCodeAssociatedService(codeAssociatedService);
			return ResponseEntity.ok("OK");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> createAccountAssociatedService(
			@RequestBody AccountAssociatedService accountAssociatedService) {
		try {
			this.service.save(accountAssociatedService);
			return ResponseEntity.ok("OK");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAccountAssociatedService(
			@RequestBody AccountAssociatedService accountAssociatedService) {
		try {
			this.service.update(accountAssociatedService);
			return ResponseEntity.ok("OK");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@RequestMapping("/all")
	public Object findAll() {
		return this.service.findAll();
	}

}

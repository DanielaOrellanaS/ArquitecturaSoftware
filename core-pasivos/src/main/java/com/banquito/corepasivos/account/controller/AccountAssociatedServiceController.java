package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.model.AccountAssociatedService;
import com.banquito.corepasivos.account.services.AccountAssociatedServiceService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accountAssociatedService")
public class AccountAssociatedServiceController {
	private final AccountAssociatedServiceService service;

	public AccountAssociatedServiceController(AccountAssociatedServiceService service) {
		this.service = service;
	}

	@GetMapping("/findByCodeLocalAccount/{codeLocalAccount}")
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

	@GetMapping("/findByCodeInternationalAccount/{codeInternationalAccount}")
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

	@GetMapping("/findByCodeProduct/{codeProduct}")
	public ResponseEntity<List<AccountAssociatedService>> findByCodeProduct(
			@PathVariable("codeProduct") String codeProduct) {

		List<AccountAssociatedService> accountAssociatedService = this.service.findByCodeProduct(codeProduct);
		if (accountAssociatedService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountAssociatedService);
		}

	}

	@GetMapping("/findByCodeProductType/{codeProductType}")
	public ResponseEntity<List<AccountAssociatedService>> findByCodeProductType(
			@PathVariable("codeProductType") String codeProductType) {

		List<AccountAssociatedService> accountAssociatedService = this.service.findByCodeProductType(codeProductType);
		if (accountAssociatedService.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountAssociatedService);
		}

	}

	@GetMapping("/findByCodeAssociatedService/{codeAssociatedService}")
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

	@DeleteMapping("/deleteByCodeLocalAccount/{codeLocalAccount}")
	public ResponseEntity<Void> deleteByCodeLocalAccount(
			@PathVariable("codeLocalAccount") String codeLocalAccount) {

		this.service.deleteByCodeLocalAccount(codeLocalAccount);
		return ResponseEntity.noContent().build();

	}

	@DeleteMapping("/deleteByCodeInternationalAccount/{codeInternationalAccount}")
	public ResponseEntity<Void> deleteByCodeInternationalAccount(
			@PathVariable("codeInternationalAccount") String codeInternationalAccount) {

		this.service.deleteByCodeInternationalAccount(codeInternationalAccount);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/deleteByCodeAssociatedService/{codeAssociatedService}")
	public ResponseEntity<Void> deleteByCodeAssociatedService(
			@PathVariable("codeAssociatedService") String codeAssociatedService) {

		this.service.deleteByCodeAssociatedService(codeAssociatedService);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping("/all")
	public Object findAll() {
		return this.service.findAll();
	}

}

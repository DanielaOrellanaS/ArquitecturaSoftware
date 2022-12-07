package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.model.AccountAssociatedServiceParam;
import com.banquito.corepasivos.account.services.AccountAssociatedServiceParamService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account-associated-service-param")
public class AccountAssociatedServiceParamController {
	private final AccountAssociatedServiceParamService service;

	public AccountAssociatedServiceParamController(
			AccountAssociatedServiceParamService service) {
		this.service = service;
	}

	@RequestMapping(value = "/local/{codeLocalAccount}", method = RequestMethod.GET)
	public ResponseEntity<List<AccountAssociatedServiceParam>> findByCodeLocalAccount(
			@PathVariable("codeLocalAccount") String codeLocalAccount) {
		List<AccountAssociatedServiceParam> accountAssociatedServiceParam = this.service
				.findByCodeLocalAccount(codeLocalAccount);
		if (accountAssociatedServiceParam.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountAssociatedServiceParam);
		}
	}

	@RequestMapping(value = "/international/{codeInternationalAccount}", method = RequestMethod.GET)
	public ResponseEntity<List<AccountAssociatedServiceParam>> findByCodeInternationalAccount(
			@PathVariable("codeInternationalAccount") String codeInternationalAccount) {
		List<AccountAssociatedServiceParam> accountAssociatedServiceParam = this.service
				.findByCodeInternationalAccount(codeInternationalAccount);
		if (accountAssociatedServiceParam.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountAssociatedServiceParam);
		}
	}

	@RequestMapping(value = "/code-param/{codeParam}", method = RequestMethod.GET)
	public ResponseEntity<List<AccountAssociatedServiceParam>> findByCodeParam(
			@PathVariable("codeParam") String codeParam) {
		List<AccountAssociatedServiceParam> accountAssociatedServiceParam = this.service
				.findByCodeParam(codeParam);
		if (accountAssociatedServiceParam.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(accountAssociatedServiceParam);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> createAccountAssociatedServiceParam(
			@RequestBody AccountAssociatedServiceParam accountAssociatedServiceParam) {
		try {
			this.service.save(accountAssociatedServiceParam);
			return ResponseEntity.ok("Account Associated Service Param created successfully");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAccountAssociatedServiceParam(
			@RequestBody AccountAssociatedServiceParam accountAssociatedServiceParam) {
		try {
			this.service.save(accountAssociatedServiceParam);
			return ResponseEntity.ok("Account Associated Service Param updated successfully");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@RequestMapping(value = "/local/{codeLocalAccount}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteByCodeLocalAccount(
			@PathVariable("codeLocalAccount") String codeLocalAccount) {
		try {
			this.service.deleteAllByCodeLocalAccount(codeLocalAccount);
			return ResponseEntity.ok("Account Associated Service Param related to Local Account deleted successfully");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@RequestMapping(value = "/international/{codeInternationalAccount}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteByCodeInternationalAccount(
			@PathVariable("codeInternationalAccount") String codeInternationalAccount) {
		try {
			this.service.deleteAllByCodeInternationalAccount(codeInternationalAccount);
			return ResponseEntity
					.ok("Account Associated Service Param related to International Account deleted successfully");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@RequestMapping(value = "/code-param/{codeParam}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteByCodeParam(
			@PathVariable("codeParam") String codeParam) {
		try {
			this.service.deleteAllByCodeParam(codeParam);
			return ResponseEntity.ok("Account Associated Service Param related to Param deleted successfully");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@RequestMapping("/all")
	public Object findAll() {
		return this.service.findAll();
	}

}

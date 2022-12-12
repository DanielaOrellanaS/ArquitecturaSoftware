package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.dto.response.AccountAssociatedServiceResDto;
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
@RequestMapping("api/account-associated-service")
public class AccountAssociatedServiceController {
	private final AccountAssociatedServiceService service;

	public AccountAssociatedServiceController(AccountAssociatedServiceService service) {
		this.service = service;
	}

	@RequestMapping(value = "/local/{codeLocalAccount}/international/{codeInternationalAccount}", method = RequestMethod.GET)
	public ResponseEntity<List<AccountAssociatedServiceResDto>> findByCodeLocalAccountAndCodeInternationalAccount(
			@PathVariable("codeLocalAccount") String codeLocalAccount,
			@PathVariable("codeInternationalAccount") String codeInternationalAccount) {

		List<AccountAssociatedServiceResDto> accountAssociatedService = this.service
				.findByCodeLocalAccountAndCodeInternationalAccount(codeLocalAccount, codeInternationalAccount);
		try {
			if (accountAssociatedService.isEmpty()) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(accountAssociatedService);
			}
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(value = "/local/{codeLocalAccount}/international/{codeInternationalAccount}/status/{status}", method = RequestMethod.GET)
	public ResponseEntity<List<AccountAssociatedServiceResDto>> findByCodeLocalAccountAndCodeInternationalAccountAndStatus(
			@PathVariable("codeLocalAccount") String codeLocalAccount,
			@PathVariable("codeInternationalAccount") String codeInternationalAccount,
			@PathVariable("status") String status) {

		List<AccountAssociatedServiceResDto> accountAssociatedService = this.service
				.findByCodeLocalAccountAndCodeInternationalAccountAndStatus(codeLocalAccount, codeInternationalAccount,
						status);
		try {
			if (accountAssociatedService.isEmpty()) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(accountAssociatedService);
			}
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> createAccountAssociatedService(
			@RequestBody AccountAssociatedService accountAssociatedService) {
		try {
			this.service.save(accountAssociatedService);
			return ResponseEntity.ok("Account associated service created successfully");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAccountAssociatedService(
			@RequestBody AccountAssociatedService accountAssociatedService) {
		try {
			this.service.update(accountAssociatedService);
			return ResponseEntity.ok("Account associated service updated successfully");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@RequestMapping(value = "/local/{codeLocalAccount}/international/{codeInternationalAccount}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAllByCodeLocalAccountAndCodeInternationalAccount(
			@PathVariable("codeLocalAccount") String codeLocalAccount,
			@PathVariable("codeInternationalAccount") String codeInternationalAccount) {

		try {
			this.service.deleteAllByLocalInternationalCodeAccount(codeLocalAccount, codeInternationalAccount);
			return ResponseEntity
					.ok("Record deleted successfully");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@RequestMapping(value = "/international/{codeInternationalAccount}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAllByCodeInternationalAccount(
			@PathVariable("codeInternationalAccount") String codeInternationalAccount) {

		try {
			this.service.deleteAllByCodeInternationalAccount(codeInternationalAccount);
			return ResponseEntity
					.ok("All account associated services related to the international account were deleted ");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@RequestMapping(value = "/code-associated-service/{codeAssociatedService}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAllByCodeAssociatedService(
			@PathVariable("codeAssociatedService") String codeAssociatedService) {

		try {
			this.service.deleteAllByCodeAssociatedService(codeAssociatedService);
			return ResponseEntity.ok("All account associated services related to the associated service were deleted ");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@RequestMapping(value = "/code-associated-service/{codeAssociatedService}/{codeLocalAccount}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteByCodeAssociatedServiceAndCodeLocalAccount(
			@PathVariable("codeAssociatedService") String codeAssociatedService,
			@PathVariable("codeLocalAccount") String codeLocalAccount) {

		try {
			this.service.deleteByCodeAssociatedService(codeAssociatedService, codeLocalAccount);
			return ResponseEntity
					.ok("Account associated service by code associated service and code local account deleted");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

}

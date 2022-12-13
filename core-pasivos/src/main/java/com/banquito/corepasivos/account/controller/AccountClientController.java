package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.dto.request.AccountClientCompleteReqDto;
import com.banquito.corepasivos.account.dto.request.AccountClientReqDto;
import com.banquito.corepasivos.account.dto.response.AccountClientResDto;
import com.banquito.corepasivos.account.dto.response.AccountClientResStatusDto;
import com.banquito.corepasivos.account.services.AccountClientService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account-client")
public class AccountClientController {
    private final AccountClientService accountClientService;

    public AccountClientController(AccountClientService accountClientService) {
        this.accountClientService = accountClientService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody AccountClientReqDto accountClient) {
        try {
            this.accountClientService.save(accountClient);
            return ResponseEntity.ok("Record saved successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/local/{codeLocalAccount}/international/{codeInternationalAccount}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountClientResStatusDto>> findByCodeLocalAccount(
            @PathVariable("codeLocalAccount") String codeLocalAccount,
            @PathVariable("codeInternationalAccount") String codeInternationalAccount) {
        List<AccountClientResStatusDto> accountsById = this.accountClientService
                .findById(codeLocalAccount, codeInternationalAccount);

        if (accountsById.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountsById);
    }

    @RequestMapping(value = "/local/{codeLocalAccount}/international/{codeInternationalAccount}/status/{status}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountClientResDto>> findByStatus(
            @PathVariable("codeLocalAccount") String codeLocalAccount,
            @PathVariable("codeInternationalAccount") String codeInternationalAccount,
            @PathVariable("status") String status) {
        List<AccountClientResDto> accountsByStatus = this.accountClientService.findByStatus(codeLocalAccount,
                codeInternationalAccount, status);

        if (accountsByStatus.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountsByStatus);
    }

    @RequestMapping(value = "/local/{codeLocalAccount}/international/{codeInternationalAccount}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateById(
            @PathVariable("codeLocalAccount") String codeLocalAccount,
            @PathVariable("codeInternationalAccount") String codeInternationalAccount,
            @RequestBody AccountClientCompleteReqDto accountClient) {
        try {
            this.accountClientService.updateById(codeLocalAccount, codeInternationalAccount, accountClient);
            return ResponseEntity.ok("Record updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/local/{codeLocalAccount}/international/{codeInternationalAccount}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteByCodeLocalAccount(
            @PathVariable("codeLocalAccount") String codeLocalAccount,
            @PathVariable("codeInternationalAccount") String codeInternationalAccount) {
        try {
            this.accountClientService.deleteById(codeLocalAccount, codeInternationalAccount);
            return ResponseEntity.ok("Record deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}

package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.model.Account;
import com.banquito.corepasivos.account.services.AccountService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Account save(@RequestBody Account account) {
        return this.accountService.save(account);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findAll() {
        List<Account> accounts = this.accountService.findAll();

        if (accounts.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accounts);
    }

    @RequestMapping(value = "/local/{codeLocalAccount}", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findByCodeLocalAccount(
            @PathVariable("codeLocalAccount") String codeLocalAccount) {
        List<Account> accountsByCodeLocalAccount = this.accountService.findByCodeLocalAccount(codeLocalAccount);

        if (accountsByCodeLocalAccount.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountsByCodeLocalAccount);
    }

    @RequestMapping(value = "/international/{codeInternationalAccount}", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findByCodeInternationalAccount(
            @PathVariable("codeInternationalAccount") String codeInternationalAccount) {
        List<Account> accountsByCodeInternationalAccount = this.accountService
                .findByCodeInternationalAccount(codeInternationalAccount);

        if (accountsByCodeInternationalAccount.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountsByCodeInternationalAccount);
    }

    @RequestMapping(value = "/product/{codeProduct}", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findByCodeProduct(
            @PathVariable("codeProduct") String codeProduct) {
        List<Account> accountsBycodeProduct = this.accountService.findByCodeProduct(codeProduct);

        if (accountsBycodeProduct.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountsBycodeProduct);
    }

    @RequestMapping(value = "/product-type/{codeProductType}", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findByCodeProductType(
            @PathVariable("codeProductType") String codeProductType) {
        List<Account> accountsBycodeProductType = this.accountService.findByCodeProductType(codeProductType);

        if (accountsBycodeProductType.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountsBycodeProductType);
    }

    @RequestMapping(value = "/branch/{codeBranch}", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findByCodeBranch(
            @PathVariable("codeBranch") String codeBranch) {
        List<Account> accountsBycodeBranch = this.accountService.findByCodeBranch(codeBranch);

        if (accountsBycodeBranch.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountsBycodeBranch);
    }

    @RequestMapping(value = "/entity-bank/{entityBankCode}", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findByEntityBankCode(
            @PathVariable("entityBankCode") String entityBankCode) {
        List<Account> accountsByentityBankCode = this.accountService.findByEntityBankCode(entityBankCode);

        if (accountsByentityBankCode.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountsByentityBankCode);
    }

    @RequestMapping(value = "/international-bank/{internationalBankCode}", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findByInternationalBankCode(
            @PathVariable("internationalBankCode") String internationalBankCode) {
        List<Account> accountsByinternationalBankCode = this.accountService
                .findByInternationalBankCode(internationalBankCode);

        if (accountsByinternationalBankCode.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountsByinternationalBankCode);
    }

    @RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findByStatus(@PathVariable("status") String status) {
        List<Account> accountsBystatus = this.accountService.findByStatus(status);

        if (accountsBystatus.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountsBystatus);
    }

    @RequestMapping(value = "/local/{codeLocalAccount}", method = RequestMethod.PUT)
    public Account updateByCodeLocalAccount(@RequestBody Account account,
            @PathVariable("codeLocalAccount") String codeLocalAccount) {
        return this.accountService.updateByCodeLocalAccount(codeLocalAccount, account);
    }

    @RequestMapping(value = "/international/{codeInternationalAccount}", method = RequestMethod.PUT)
    public Account updateByCodeInternationalAccount(@RequestBody Account account,
            @PathVariable("codeInternationalAccount") String codeInternationalAccount) {
        return this.accountService.updateByCodeInternationalAccount(codeInternationalAccount, account);
    }

    @RequestMapping(value = "/local/{codeLocalAccount}", method = RequestMethod.DELETE)
    public Account deleteByCodeLocalAccount(
            @PathVariable("codeLocalAccount") String codeLocalAccount) {
        return this.accountService.deleteByCodeLocalAccount(codeLocalAccount);
    }

    @RequestMapping(value = "/international/{codeInternationalAccount}", method = RequestMethod.DELETE)
    public Account deleteByCodeInternationalAccount(
            @PathVariable("codeInternationalAccount") String codeInternationalAccount) {
        return this.accountService.deleteByCodeInternationalAccount(codeInternationalAccount);
    }
}

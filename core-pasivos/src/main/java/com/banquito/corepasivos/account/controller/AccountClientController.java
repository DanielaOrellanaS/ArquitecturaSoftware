package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.model.AccountClient;
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
    public AccountClient save(@RequestBody AccountClient accountClient) {
        return this.accountClientService.save(accountClient);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<AccountClient>> findAll() {
        List<AccountClient> accountClients = this.accountClientService.findAll();

        if (accountClients.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountClients);
    }

    @RequestMapping(value = "/local/{codeLocalAccount}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountClient>> findByCodeLocalAccount(
            @PathVariable("codeLocalAccount") String codeLocalAccount) {
        List<AccountClient> accountsByCodeLocalAccount = this.accountClientService
                .findByCodeLocalAccount(codeLocalAccount);

        if (accountsByCodeLocalAccount.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountsByCodeLocalAccount);
    }

    @RequestMapping(value = "/international/{codeInternationalAccount}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountClient>> findByCodeInternationalAccount(
            @PathVariable("codeInternationalAccount") String codeInternationalAccount) {
        List<AccountClient> accountsByCodeInternationalAccount = this.accountClientService
                .findByCodeInternationalAccount(codeInternationalAccount);

        if (accountsByCodeInternationalAccount.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountsByCodeInternationalAccount);
    }

    @RequestMapping(value = "/identification-type/{identificationType}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountClient>> findByidentificationType(
            @PathVariable("identificationType") String identificationType) {
        List<AccountClient> accountsByIdentificationType = this.accountClientService
                .findByIndentificationType(identificationType);

        if (accountsByIdentificationType.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountsByIdentificationType);
    }

    @RequestMapping(value = "/identification/{identification}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountClient>> findByidentification(
            @PathVariable("identification") String identification) {
        List<AccountClient> accountsByIdentification = this.accountClientService
                .findByIndentification(identification);

        if (accountsByIdentification.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountsByIdentification);
    }

    @RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountClient>> findByStatus(@PathVariable("status") String status) {
        List<AccountClient> accountsByStatus = this.accountClientService.findByStatus(status);

        if (accountsByStatus.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountsByStatus);
    }

    @RequestMapping(value = "/local/{codeLocalAccount}", method = RequestMethod.PUT)
    public ResponseEntity<AccountClient> updateByCodeLocalAccount(@RequestBody AccountClient accountClient,
            @PathVariable("codeLocalAccount") String codeLocalAccount) {
        return ResponseEntity.ok(this.accountClientService.updateByCodeLocalAccount(codeLocalAccount, accountClient));
    }

    @RequestMapping(value = "/international/{codeInternationalAccount}", method = RequestMethod.PUT)
    public ResponseEntity<AccountClient> updateByCodeInternationalAccount(@RequestBody AccountClient accountClient,
            @PathVariable("codeInternationalAccount") String codeInternationalAccount) {
        return ResponseEntity
                .ok(this.accountClientService.updateByCodeInternationalAccount(codeInternationalAccount,
                        accountClient));
    }

    @RequestMapping(value = "/identification/{identification}", method = RequestMethod.PUT)
    public ResponseEntity<AccountClient> updateByIdentification(@RequestBody AccountClient accountClient,
            @PathVariable("identification") String identification) {
        return ResponseEntity.ok(this.accountClientService.updateByIdentification(identification, accountClient));
    }

    @RequestMapping(value = "/local/{codeLocalAccount}", method = RequestMethod.DELETE)
    public ResponseEntity<AccountClient> deleteByCodeLocalAccount(
            @PathVariable("codeLocalAccount") String codeLocalAccount) {
        return ResponseEntity.ok(this.accountClientService.deleteByCodeLocalAccount(codeLocalAccount));
    }

    @RequestMapping(value = "/international/{codeInternationalAccount}", method = RequestMethod.DELETE)
    public ResponseEntity<AccountClient> deleteByCodeInternationalAccount(
            @PathVariable("codeInternationalAccount") String codeInternationalAccount) {
        return ResponseEntity.ok(this.accountClientService.deleteByCodeInternationalAccount(codeInternationalAccount));
    }

    @RequestMapping(value = "/identification/{identification}", method = RequestMethod.DELETE)
    public ResponseEntity<AccountClient> deleteByIdentification(
            @PathVariable("identification") String identification) {
        return ResponseEntity.ok(this.accountClientService.deleteByIdentification(identification));
    }
}

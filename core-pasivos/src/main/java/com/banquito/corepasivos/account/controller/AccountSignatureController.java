package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.dto.request.AccountSignatureCreateDto;
import com.banquito.corepasivos.account.dto.response.AccountSignatureAccountDatesDto;
import com.banquito.corepasivos.account.dto.response.AccountSignatureAccountIdentificationDto;
import com.banquito.corepasivos.account.dto.response.AccountSignatureAccountStatusDto;
import com.banquito.corepasivos.account.dto.response.AccountSignatureIdentificationDatesDto;
import com.banquito.corepasivos.account.dto.response.AccountSignatureIdentificationStatusDto;
import com.banquito.corepasivos.account.model.AccountSignature;
import com.banquito.corepasivos.account.services.AccountSignatureService;

import java.lang.ProcessBuilder.Redirect.Type;
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
@RequestMapping("api/account-signature")
public class AccountSignatureController {
    private final AccountSignatureService accountSignatureService;

    public AccountSignatureController(AccountSignatureService accountSignatureService) {
        this.accountSignatureService = accountSignatureService;
    }

    @RequestMapping(value = "/localAcc/{local}/internationalAcc/{international}/indentificationType/{identificationType}/identification/{identification}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountSignatureAccountIdentificationDto>> findByPrimaryKey(
            @PathVariable("local") String local, @PathVariable("international") String international,
            @PathVariable("identificationType") String type, @PathVariable("identification") String identification) {
        List<AccountSignatureAccountIdentificationDto> accountIdentificationDtos = this.accountSignatureService
                .findByPk(local, international, type, identification);
        if (accountIdentificationDtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(accountIdentificationDtos);
        }
    }

    @RequestMapping(value = "/localAcc/{local}/internationalAcc/{international}/startDate/{start-date}/endDate/{end-date}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountSignatureIdentificationDatesDto>> findByAccountDates(
            @PathVariable("local") String local, @PathVariable("international") String international,
            @PathVariable("start-date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable("end-date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<AccountSignatureIdentificationDatesDto> accountSignatureDatesDtos = this.accountSignatureService
                .findByAccountDates(local, international, startDate,
                        endDate);
        if (accountSignatureDatesDtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(accountSignatureDatesDtos);
        }
    }

    @RequestMapping(value = "/identification/{identification}/identificationType/{identificationType}/startDate/{start-date}/endDate/{end-date}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountSignatureAccountDatesDto>> findByIdentificationDates(
            @PathVariable("identification") String identification,
            @PathVariable("identificationType") String identificationType,
            @PathVariable("start-date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable("end-date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<AccountSignatureAccountDatesDto> accountSignatureDatesDtos = this.accountSignatureService
                .findByIdentificationDates(identification, identificationType, startDate,
                        endDate);
        if (accountSignatureDatesDtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(accountSignatureDatesDtos);
        }
    }

    @RequestMapping(value = "/localAcc/{local}/internationalAcc/{international}/status/{status}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountSignatureIdentificationStatusDto>> findByAccountStatus(
            @PathVariable("local") String local, @PathVariable("international") String international,
            @PathVariable("status") String status) {
        List<AccountSignatureIdentificationStatusDto> accountSignatures = this.accountSignatureService
                .findByAccountStatus(local, international,
                        status);
        if (accountSignatures.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(accountSignatures);
        }
    }

    @RequestMapping(value = "/identification/{identification}/identificationType/{identificationType}/status/{status}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountSignatureAccountStatusDto>> findByIdentificationStatus(
            @PathVariable("identification") String identification,
            @PathVariable("identificationType") String identificationType,
            @PathVariable("status") String status) {
        List<AccountSignatureAccountStatusDto> accountSignatures = this.accountSignatureService
                .findByIdentificationStatus(identification, identificationType,
                        status);
        if (accountSignatures.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(accountSignatures);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createAccountSignature(
            @RequestBody AccountSignatureCreateDto accountSignatureCreateDto) {
        try {
            this.accountSignatureService.register(accountSignatureCreateDto);
            return ResponseEntity.ok("Record saved succesfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/local/{codeLocalAccount}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateByCodeLocalAccount(@PathVariable("codeLocalAccount") String codeLocalAccount,
            @RequestBody AccountSignature accountSignature) {

        try {
            this.accountSignatureService.updateByCodeLocalAccount(codeLocalAccount, accountSignature);
            return ResponseEntity.ok("Account updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/localAcc/{local}/internationalAcc/{international}/indentificationType/{identificationType}/identification/{identification}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAccountSignature(
            @PathVariable("local") String local, @PathVariable("international") String international,
            @PathVariable("identificationType") String type, @PathVariable("identification") String identification) {
        try {
            this.accountSignatureService.delete(local, international, type, identification);
            return ResponseEntity.ok("Record deleted succesfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}

package com.banquito.corepasivos.general.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import com.banquito.corepasivos.general.model.BankEntity;
import com.banquito.corepasivos.general.model.BankEntityPK;
import com.banquito.corepasivos.general.service.BankEntityService;

@RestController
@RequestMapping("/api/bank")
public class BankEntityController {

    private final BankEntityService bankEntityService;

    public BankEntityController(BankEntityService bankEntityService) {
        this.bankEntityService = bankEntityService;
    }

    @PostMapping
    public ResponseEntity<String> newBankEntity(@RequestBody BankEntity bankEntity) {
        try {
            this.bankEntityService.create(bankEntity);
            ;
            return ResponseEntity.ok("Bank Entity created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping(consumes = { "application/json" })
    public ResponseEntity<String> updateBankEntity(@RequestBody BankEntity bankEntity) {
        try {
            this.bankEntityService.update(bankEntity);
            return ResponseEntity.ok("Bank Entity updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping(consumes = { "application/json" })
    public ResponseEntity<String> deleteBankEntity(@RequestBody BankEntity bankEntity) {
        try {
            this.bankEntityService.delete(bankEntity);
            return ResponseEntity.ok("Bank Entity delete successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<BankEntity>> getBankEntity() {
        return ResponseEntity.ok(this.bankEntityService.findAll());
    }

    @GetMapping(consumes = { "application/json" })
    public ResponseEntity<Optional<BankEntity>> getBankEntityById(@RequestBody BankEntityPK bankEntityPK) {
        return ResponseEntity.ok(this.bankEntityService.findById(bankEntityPK));
    }

}

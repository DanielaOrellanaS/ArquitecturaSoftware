package com.banquito.corepasivos.general.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import com.banquito.corepasivos.general.model.BankEntity;
import com.banquito.corepasivos.general.model.BankEntityPK;
import com.banquito.corepasivos.general.service.BankEntityService;

@RestController
@RequestMapping("/api/bank-entity")
public class BankEntityController {

    private final BankEntityService bankEntityService;

    public BankEntityController(BankEntityService bankEntityService) {
        this.bankEntityService = bankEntityService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<BankEntity>> getBankEntity() {
        return ResponseEntity.ok(this.bankEntityService.findAll());
    }

    @RequestMapping(value = "/{bank}/{bankInternational}", method = RequestMethod.GET)
    public ResponseEntity<BankEntity> findBank(
            @PathVariable("bank") String bank,
            @PathVariable("bankInternational") String bankInternational) {
        BankEntityPK pk = new BankEntityPK();
        pk.setEntitybankcode(bank);
        pk.setInternationalbankcode(bankInternational);
        try {
            return ResponseEntity.ok(this.bankEntityService.findById(pk));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createdBankEntity(@RequestBody BankEntity bankEntity) {
        try {
            this.bankEntityService.create(bankEntity);
            return ResponseEntity.ok("Bank Entity created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBankEntity(@RequestBody BankEntity bankEntity) {
        try {
            this.bankEntityService.update(bankEntity);
            return ResponseEntity.ok("Bank Entity updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBankEntity(@RequestBody BankEntity bankEntity) {
        try {
            this.bankEntityService.delete(bankEntity);
            return ResponseEntity.ok("Bank Entity delete successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}

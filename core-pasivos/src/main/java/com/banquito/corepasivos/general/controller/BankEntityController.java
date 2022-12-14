package com.banquito.corepasivos.general.controller;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "/{entitybankcode}/{internationalbankcode}", method = RequestMethod.GET)
    public ResponseEntity<Optional<BankEntity>> getBankEntityById(
            @PathVariable("entitybankcode") String entityBankCode,
            @PathVariable("internationalbankcode") String international) {
        BankEntityPK pk = new BankEntityPK();
        pk.setEntitybankcode(entityBankCode);
        pk.setInternationalbankcode(international);
        return ResponseEntity.ok(this.bankEntityService.findByComposePK(pk));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createBankEntity(@RequestBody BankEntity bankEntity) {
        try {
            this.bankEntityService.create(bankEntity);
            return ResponseEntity.ok("Bank Entity create successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{entitybankcode}/{internationalbankcode}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBankEntity(
            @PathVariable("entitybankcode") String codeBankEntity,
            @PathVariable("internationalbankcode") String international,
            @RequestBody BankEntity bankEntity) {

        BankEntityPK pk = new BankEntityPK();
        pk.setEntitybankcode(codeBankEntity);
        pk.setInternationalbankcode(international);

        try {
            this.bankEntityService.update(bankEntity, pk);
            return ResponseEntity.ok("Bank Entity update successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{entitybankcode}/{internationalbankcode}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBankEntity(
            @PathVariable("entitybankcode") String bankEntity,
            @PathVariable("internationalbankcode") String international) {

        BankEntityPK pk = new BankEntityPK();
        pk.setEntitybankcode(bankEntity);
        pk.setInternationalbankcode(international);

        try {
            this.bankEntityService.delete(pk);
            return ResponseEntity.ok("Bank Entity delete successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}

package com.banquito.corepasivos.general.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.general.model.Branch;
import com.banquito.corepasivos.general.model.BranchPK;
import com.banquito.corepasivos.general.service.BranchService;

@RestController
@RequestMapping("/api/branch")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Branch>> findAllBranches() {
        return ResponseEntity.ok(this.branchService.findAll());
    }

    @RequestMapping(value = "/{branch}/{bank}/{bankInternational}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Branch>> findBranchBankById(
            @PathVariable("branch") String branch,
            @PathVariable("bank") String bank,
            @PathVariable("bankInternational") String bankInternational) {
        BranchPK pk = new BranchPK();
        pk.setCodebranch(branch);
        pk.setEntityBankCode(bank);
        pk.setInternationalBankCode(bankInternational);
        return ResponseEntity.ok(this.branchService.findByComposePK(pk));
    }

    @RequestMapping(value = "/namelike")
    public ResponseEntity<List<Branch>> findBranchByName(
            @RequestParam String name) {
        List<Branch> branches = this.branchService.findByNameLike("%" + name + "%");
        return ResponseEntity.ok(branches);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createBranch(@RequestBody Branch branch) {
        try {
            this.branchService.create(branch);
            return ResponseEntity.ok("Branch created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{branch}/{bank}/{bankInternational}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBranch(
            @PathVariable("branch") String branchCode,
            @PathVariable("bank") String bank,
            @PathVariable("bankInternational") String bankInternational,
            @RequestBody Branch branch) {
        BranchPK pk = new BranchPK();
        pk.setCodebranch(branchCode);
        pk.setEntityBankCode(bank);
        pk.setInternationalBankCode(bankInternational);
        try {
            this.branchService.update(branch, pk);
            return ResponseEntity.ok("Branch updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{branch}/{bank}/{bankInternational}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBranch(
            @PathVariable("branch") String branchCode,
            @PathVariable("bank") String bank,
            @PathVariable("bankInternational") String bankInternational) {
        BranchPK pk = new BranchPK();
        pk.setCodebranch(branchCode);
        pk.setEntityBankCode(bank);
        pk.setInternationalBankCode(bankInternational);
        try {
            this.branchService.delete(pk);
            return ResponseEntity.ok("Branch delete successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}

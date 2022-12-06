package com.banquito.corepasivos.general.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createdBranch(@RequestBody Branch branch) {
        try {
            this.branchService.create(branch);
            ;
            return ResponseEntity.ok("Branch created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBranch(@RequestBody Branch branch) {
        try {
            this.branchService.update(branch);
            return ResponseEntity.ok("Branch updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBranch(@RequestBody Branch branch) {
        try {
            this.branchService.delete(branch);
            return ResponseEntity.ok("Branch delete successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Branch>> getBranch() {
        return ResponseEntity.ok(this.branchService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Branch>> getBankEntityById(@RequestBody BranchPK branchPK) {
        return ResponseEntity.ok(this.branchService.findById(branchPK));
    }
}

package com.banquito.corepasivos.general.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.general.model.Branch;
import com.banquito.corepasivos.general.model.BranchPK;
import com.banquito.corepasivos.general.service.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping
    public ResponseEntity<String> createdBranch(@RequestBody Branch branch) {
        try {
            this.branchService.create(branch);
            ;
            return ResponseEntity.ok("Branch created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping(consumes = { "application/json" })
    public ResponseEntity<String> updateBranch(@RequestBody Branch branch) {
        try {
            this.branchService.update(branch);
            return ResponseEntity.ok("Branch updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping(consumes = { "application/json" })
    public ResponseEntity<String> deleteBranch(@RequestBody Branch branch) {
        try {
            this.branchService.delete(branch);
            return ResponseEntity.ok("Branch delete successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Branch>> getBranch() {
        return ResponseEntity.ok(this.branchService.findAll());
    }

    @GetMapping(consumes = { "application/json" })
    public ResponseEntity<Optional<Branch>> getBankEntityById(@RequestBody BranchPK branchPK) {
        return ResponseEntity.ok(this.branchService.findById(branchPK));
    }
}

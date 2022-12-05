package com.banquito.corepasivos.general.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.general.service.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {
    @Autowired
    BranchService branchService;

    @GetMapping("/all")
    public Object getBranch() {
        return this.branchService.getAllBranches();
    }
}

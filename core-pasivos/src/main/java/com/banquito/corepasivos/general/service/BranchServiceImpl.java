package com.banquito.corepasivos.general.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.general.model.Branch;
import com.banquito.corepasivos.general.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    BranchRepository branchRepository;

    @Override
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }
}

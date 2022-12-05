package com.banquito.corepasivos.general.service;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.general.repository.BranchRepository;

@Service
public class BranchService {
    private final BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    // @Transactional
    // public void create(Branch branch){
    // List<Branch> branches = this.branchRepository.findByCode(branch.getPk());
    // if(branches.isEmpty()){
    // this.branchRepository.save(branch);
    // } else {
    // throw new RuntimeException("The branch already exists");
    // }
    // }

    // public Branch findByCode(String name){
    // List<Branch> branches = this.branchRepository.findByName(name);
    // return (branches.isEmpty()) ? null : branches.get(0);
    // }

}

package com.banquito.corepasivos.general.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.general.model.Branch;
import com.banquito.corepasivos.general.model.BranchPK;
import com.banquito.corepasivos.general.repository.BranchRepository;

@Service
public class BranchService {

    private final BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    
    public List<Branch> findAll() {
        return this.branchRepository.findAll();
    }

    public Optional<Branch> findByComposePK(BranchPK branchPK) {
        try {
            return this.branchRepository.findById(branchPK);
        } catch (Exception e) {
            throw new RuntimeException("The Bank Entity does not exist");
        }
    }

    public List<Branch> findByName(String name){
        return this.branchRepository.findByNameLike(name);
    }

    @Transactional
    public void create(Branch branch) {
        Optional<Branch> optional = this.branchRepository.findById(branch.getPk());
        if(optional.isPresent()){
            throw new RuntimeException("Branch already exist");
        } else {
            this.branchRepository.save(branch);
        }
    }

    @Transactional
    public void update(Branch branch) {
        Optional<Branch> optional = this.branchRepository.findById(branch.getPk());
        if(optional.isPresent()){
            this.branchRepository.save(branch);
        } else {
            throw new RuntimeException("Not found");
        }
    }

    @Transactional
    public void delete(Branch branch) {
        Optional<Branch> optional = this.branchRepository.findById(branch.getPk());
        if(optional.isPresent()){
            this.branchRepository.delete(branch);
        } else {
            throw new RuntimeException("Not found");
        }
    }
}

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

    @Transactional
    public void create(Branch branch){
        List<Branch> bankEntities = this.branchRepository.findByPkCodeBranch(branch.getPk().getCodeBranch());
        if(bankEntities.isEmpty()){
            this.branchRepository.save(branch);
        }
        else{
            throw new RuntimeException("The Branch already exists");
        }
    }
    
    @Transactional
    public void update(Branch branch){
        List<Branch> bankEntities = this.branchRepository.findByPkCodeBranch(branch.getPk().getCodeBranch());
        if(!bankEntities.isEmpty()){
            this.branchRepository.save(branch);
        }
        else{
            throw new RuntimeException("An error has occurred in the Branch update");
        }
    } 
    
    @Transactional
    public void delete(Branch branch){
        List<Branch> bankEntities = this.branchRepository.findByPkCodeBranch(branch.getPk().getCodeBranch());
        if (!bankEntities.isEmpty()){
            this.branchRepository.delete(branch);
        }   
        else{
            throw new RuntimeException("The Bank Entity does not exist");
        }
    }

    public Optional<Branch> findById(BranchPK branchPK){
        try {
            return this.branchRepository.findById(branchPK);
        } catch (Exception e) {
            throw new RuntimeException("The Bank Entity does not exist");
        }
    }

    public List<Branch> findAll(){
        return this.branchRepository.findAll();
    }
}

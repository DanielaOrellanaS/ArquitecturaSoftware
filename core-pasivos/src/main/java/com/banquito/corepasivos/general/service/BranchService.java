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
            throw new RuntimeException("The Branch does not exist");
        }
    }

    public List<Branch> findByNameLike(String name) {
        return this.branchRepository.findByNameLike(name);
    }

    @Transactional
    public void create(Branch branch) {
        Optional<Branch> optional = this.branchRepository.findById(branch.getPk());
        if (optional.isPresent()) {
            throw new RuntimeException("Branch already exist");
        } else {
            this.branchRepository.save(branch);
        }
    }

    @Transactional
    public void update(Branch branch, BranchPK pk) {
        Optional<Branch> optional = this.branchRepository.findById(pk);
        if (optional.isPresent()) {
            this.branchRepository.save(branch);
        } else {
            throw new RuntimeException("Not found");
        }
    }

    @Transactional
    public void delete(BranchPK branch) {
        Optional<Branch> optional = this.branchRepository.findById(branch);
        if (optional.isPresent()) {
            this.branchRepository.delete(optional.get());
        } else {
            throw new RuntimeException("Not found");
        }
    }
}

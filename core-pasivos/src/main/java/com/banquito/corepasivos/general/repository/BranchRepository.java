package com.banquito.corepasivos.general.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.general.model.Branch;
import com.banquito.corepasivos.general.model.BranchPK;

@Repository
public interface BranchRepository extends JpaRepository<Branch, BranchPK> {
    List<Branch> findByPkCodeBranch(String codeBranch);

    List<Branch> findByPkEntityBankCode(String entityBankCode);

    List<Branch> findByPkInternationalBankCode(String iInternationalBankCode);
}

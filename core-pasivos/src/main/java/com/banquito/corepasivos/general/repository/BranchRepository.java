package com.banquito.corepasivos.general.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.general.model.Branch;
import com.banquito.corepasivos.general.model.BranchPK;

@Repository
public interface BranchRepository extends JpaRepository<Branch, BranchPK> {

    List<Branch> findByCode(BranchPK codeBranch);

    List<Branch> findByEntityBankCode(BranchPK codeBranch);

    List<Branch> findByInternationalBranchCode(BranchPK internationalBranchCode);

    List<Branch> findByCodeLocation(BranchPK codeLocation);

    List<Branch> findByName(String name);
    

    // Tipo dato parametro PK o primirtivo?
}

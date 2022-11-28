package com.banquito.corepasivos.general.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.general.model.Branch;
import com.banquito.corepasivos.general.model.BranchPK;

public interface BranchRepository extends JpaRepository<Branch, BranchPK> {

}

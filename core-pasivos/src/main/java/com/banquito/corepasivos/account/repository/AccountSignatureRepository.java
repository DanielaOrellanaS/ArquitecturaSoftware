package com.banquito.corepasivos.account.repository;

import com.banquito.corepasivos.account.model.AccountSignature;
import com.banquito.corepasivos.account.model.AccountSignaturePK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountSignatureRepository extends JpaRepository<AccountSignature, AccountSignaturePK> {
    
}

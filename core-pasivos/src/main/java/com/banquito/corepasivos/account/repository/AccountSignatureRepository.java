package com.banquito.corepasivos.account.repository;

import com.banquito.corepasivos.account.model.AccountSignature;
import com.banquito.corepasivos.account.model.AccountSignaturePK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountSignatureRepository extends JpaRepository<AccountSignature, AccountSignaturePK> {
    List <AccountSignature> findByPkCodelocalaccount(String code);
    List <AccountSignature> findBySignaturereference(String reference);
}

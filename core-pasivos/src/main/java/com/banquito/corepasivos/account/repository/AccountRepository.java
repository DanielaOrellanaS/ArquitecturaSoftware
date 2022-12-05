package com.banquito.corepasivos.account.repository;

import com.banquito.corepasivos.account.model.Account;
import com.banquito.corepasivos.account.model.AccountPK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, AccountPK> {

    List<Account> findByPkCodelocalaccount(String codeLocalAccount);

    List<Account> findByPkCodeinternationalaccount(String codeInternationalAccount);

    List<Account> findByCodeProduct(String codeProduct);

    List<Account> findByCodeProductType(String codeProductType);

    List<Account> findByCodeBranch(String codeBranch);

    List<Account> findByEntityBankCode(String entitybankCode);

    List<Account> findByInternationalBankCode(String internationalBankCode);

    List<Account> findByStatus(String status);

    Boolean existsByPkCodelocalaccount(String codeLocalAccount);

    Boolean existsByPkCodeinternationalaccount(String codeInternationalAccount);
}

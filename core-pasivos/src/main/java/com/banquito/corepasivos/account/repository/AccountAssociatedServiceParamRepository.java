package com.banquito.corepasivos.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.account.model.AccountAssociatedServicePK;
import com.banquito.corepasivos.account.model.AccountAssociatedServiceParam;

@Repository
public interface AccountAssociatedServiceParamRepository
        extends JpaRepository<AccountAssociatedServiceParam, AccountAssociatedServicePK> {
}

package com.banquito.corepasivos.account.repository;

import com.banquito.corepasivos.account.model.AccountAssociatedServiceParam;
import com.banquito.corepasivos.account.model.AccountAssociatedServiceParamPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountAssociatedServiceParamRepository extends
        JpaRepository<AccountAssociatedServiceParam, AccountAssociatedServiceParamPK> {
}

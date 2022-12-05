package com.banquito.corepasivos.account.repository;

import com.banquito.corepasivos.account.model.AccountAssociatedService;
import com.banquito.corepasivos.account.model.AccountAssociatedServicePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountAssociatedServiceRepository extends JpaRepository<AccountAssociatedService, AccountAssociatedServicePK> {
}

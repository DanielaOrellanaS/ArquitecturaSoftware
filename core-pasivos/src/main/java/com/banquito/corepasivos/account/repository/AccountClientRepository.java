package com.banquito.corepasivos.account.repository;

import com.banquito.corepasivos.account.model.AccountClient;
import com.banquito.corepasivos.account.model.AccountClientPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountClientRepository extends JpaRepository<AccountClient, AccountClientPK> {
}

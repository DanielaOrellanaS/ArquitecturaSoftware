package com.banquito.corepasivos.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.account.model.AccountClient;
import com.banquito.corepasivos.account.model.AccountClientPK;

@Repository
public interface AccountClientRepository
                extends JpaRepository<AccountClient, AccountClientPK> {
}

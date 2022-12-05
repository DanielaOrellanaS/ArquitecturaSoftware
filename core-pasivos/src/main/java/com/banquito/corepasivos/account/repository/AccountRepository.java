package com.banquito.corepasivos.account.repository;

import com.banquito.corepasivos.account.model.Account;
import com.banquito.corepasivos.account.model.AccountPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, AccountPK> {
}

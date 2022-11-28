package com.banquito.corepasivos.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.account.model.Account;
import com.banquito.corepasivos.account.model.AccountPK;

@Repository
public interface AccountRepository extends JpaRepository<Account, AccountPK> {
	java.util.List<Account> findByPkCodeAccount(Integer codeAccount);
}

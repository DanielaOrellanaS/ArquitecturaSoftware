package com.banquito.corepasivos.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.account.model.Account;
import com.banquito.corepasivos.account.model.AccountPK;

@Repository
public interface AccountRepository extends JpaRepository<Account, AccountPK> {
	List<Account> findByPkCodeAccount(Integer codeAccount);
}

package com.banquito.corepasivos.account.repository;

import com.banquito.corepasivos.account.model.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Integer> {

}

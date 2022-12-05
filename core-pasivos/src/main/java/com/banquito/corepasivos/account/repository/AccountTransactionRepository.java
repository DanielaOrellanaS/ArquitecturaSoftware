package com.banquito.corepasivos.account.repository;

import com.banquito.corepasivos.account.model.AccountTransaction;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Integer> {

    List<AccountTransaction> findByCodeLocalAccount(String codeLocalAccount);
    List<AccountTransaction> findByCodeUniqueTransaction(String codeUniqueTransaction);
    List<AccountTransaction> findByStatus(String status);
    List<AccountTransaction> findByRecipientBank(String recipientBank);
    // List<AccountTransaction> findByDate(Date start, Date end);
}


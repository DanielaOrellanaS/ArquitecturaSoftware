package com.banquito.corepasivos.account.repository;

import com.banquito.corepasivos.account.model.AccountClient;
import com.banquito.corepasivos.account.model.AccountClientPK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountClientRepository extends JpaRepository<AccountClient, AccountClientPK> {

    List<AccountClient> findByPkCodelocalaccount(String codeLocalAccount);

    List<AccountClient> findByPkCodeinternationalaccount(String codeInternationalAccount);

    List<AccountClient> findByPkIdentificationtype(String identificationType);

    List<AccountClient> findByPkIdentification(String identification);

    List<AccountClient> findByStatus(String status);
}

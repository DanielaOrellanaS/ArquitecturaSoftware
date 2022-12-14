package com.banquito.corepasivos.general.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.general.model.BankEntity;
import com.banquito.corepasivos.general.model.BankEntityPK;

@Repository
public interface BankEntityRepository extends JpaRepository<BankEntity, BankEntityPK> {
    List<BankEntity> findByPkInternationalbankcode(String internationalBankCode);

    List<BankEntity> findByPkEntitybankcode(String entityBankCode);

    List<BankEntity> findAll();
}

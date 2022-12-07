package com.banquito.corepasivos.general.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.general.model.BankEntity;
import com.banquito.corepasivos.general.model.BankEntityPK;

@Repository
public interface BankEntityRepository extends JpaRepository<BankEntity, BankEntityPK> {

    List<BankEntity> findByPkInternationalBankCode(String internationalBankCode);

    List<BankEntity> findByPkEntityBankCode(String entityBankCode);

    List<BankEntity> findByName(String name);

    List<BankEntity> findAll();

}

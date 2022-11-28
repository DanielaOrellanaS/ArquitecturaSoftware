package com.banquito.corepasivos.general.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.general.model.BankEntity;

public interface BankEntityRepository extends JpaRepository<BankEntity, String> {

    List<BankEntity> findByEntityBankCode(String entityBankCode);

    List<BankEntity> findByInternationalBankCode(String internationalBankCode);

}

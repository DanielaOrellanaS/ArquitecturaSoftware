package com.banquito.corepasivos.general.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.general.model.BankEntity;
import com.banquito.corepasivos.general.model.BankEntityPK;

public interface BankEntityRepository extends JpaRepository<BankEntity, BankEntityPK> {

}

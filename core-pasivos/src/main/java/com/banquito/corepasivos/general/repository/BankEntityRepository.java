package com.banquito.corepasivos.general.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.general.model.BankEntity;

public interface BankEntityRepository extends JpaRepository<BankEntity, String> {

}

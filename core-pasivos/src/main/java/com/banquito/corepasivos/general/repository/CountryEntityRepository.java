package com.banquito.corepasivos.general.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.general.model.CountryEntity;

public interface CountryEntityRepository extends JpaRepository<CountryEntity, String> {
    List<CountryEntity> findByCodeCountry(String codeCountry);
}

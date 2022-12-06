package com.banquito.corepasivos.general.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.general.model.CountryEntity;

@Repository
public interface CountryEntityRepository extends JpaRepository<CountryEntity, String> {
    List<CountryEntity> findByCodeCountry(String codeCountry);

    List<CountryEntity> findByName(String nameCountry);

    List<CountryEntity> findAll();

}

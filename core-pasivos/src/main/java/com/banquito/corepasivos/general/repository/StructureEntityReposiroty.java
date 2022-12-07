package com.banquito.corepasivos.general.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.general.model.StructureEntity;
import com.banquito.corepasivos.general.model.StructureEntityPK;

@Repository
public interface StructureEntityReposiroty extends JpaRepository<StructureEntity, StructureEntityPK> {
    List<StructureEntity> findByCodeCountry(String internationalBankCode);

    List<StructureEntity> findAll();
}

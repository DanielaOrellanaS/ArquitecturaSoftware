package com.banquito.corepasivos.general.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.general.model.StructureEntity;
import com.banquito.corepasivos.general.model.StructureEntityPK;

@Repository
public interface StructureEntityRepository extends JpaRepository<StructureEntity, StructureEntityPK> {
    List<StructureEntity> findByPkCodecountry(String codeCountry);

    List<StructureEntity> findAll();
}

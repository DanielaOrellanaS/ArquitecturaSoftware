package com.banquito.corepasivos.general.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.general.model.StructureEntity;
import com.banquito.corepasivos.general.model.StructureEntityPK;

public interface StructureEntityReposiroty extends JpaRepository<StructureEntity, StructureEntityPK>  {
    
}

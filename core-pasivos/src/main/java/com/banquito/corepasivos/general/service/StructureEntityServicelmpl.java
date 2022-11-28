package com.banquito.corepasivos.general.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.general.model.StructureEntity;
import com.banquito.corepasivos.general.repository.StructureEntityReposiroty;

@Service
public class StructureEntityServicempl implements StructureEntityService{
    
    @Autowired
    StructureEntityReposiroty structureEntityReposiroty;

    @Override
    public List<StructureEntity> getAllStructureEntities() {
        return structureEntityReposiroty.findAll();
    }
}

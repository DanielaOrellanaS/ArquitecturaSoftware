package com.banquito.corepasivos.general.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.general.model.StructureEntity;
import com.banquito.corepasivos.general.repository.StructureEntityRepository;

@Service
public class StructureEntityService {
    private final StructureEntityRepository structureEntityRepository;

    public StructureEntityService(StructureEntityRepository structureEntityRepository) {
        this.structureEntityRepository = structureEntityRepository;
    }

    @Transactional
    public void create(StructureEntity structureEntity) {
        List<StructureEntity> structureEntities = this.structureEntityRepository
                .findByPkCodecountry(structureEntity.getPk().getCodecountry());
        if (structureEntities.isEmpty()) {
            this.structureEntityRepository.save(structureEntity);
        } else {
            throw new RuntimeException("Structure Entity already exists");
        }
    }

    @Transactional
    public void update(StructureEntity structureEntity) {
        List<StructureEntity> structureEntities = this.structureEntityRepository
                .findByPkCodecountry(structureEntity.getPk().getCodecountry());
        if (!structureEntities.isEmpty() && structureEntities.size() == 1) {
            this.structureEntityRepository.save(structureEntity);
        } else {
            throw new RuntimeException("An error has occurred in the Structure Entity update");
        }
    }

    @Transactional
    public void delete(StructureEntity structureEntity) {
        List<StructureEntity> structureEntities = this.structureEntityRepository
                .findByPkCodecountry(structureEntity.getPk().getCodecountry());
        if (!structureEntities.isEmpty()) {
            this.structureEntityRepository.delete(structureEntity);
        } else {
            throw new RuntimeException("Structure Entity does not exist");
        }
    }

    public List<StructureEntity> findAll() {
        return this.structureEntityRepository.findAll();
    }
}

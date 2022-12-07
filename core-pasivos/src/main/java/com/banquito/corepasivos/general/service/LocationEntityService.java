package com.banquito.corepasivos.general.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.general.model.LocationEntity;
import com.banquito.corepasivos.general.repository.LocationEntityRepository;
import com.banquito.corepasivos.general.repository.StructureEntityRepository;

@Service
public class LocationEntityService {
    private final LocationEntityRepository locationEntityRepository;
    private final StructureEntityRepository structureEntityRepository; 

    public LocationEntityService(LocationEntityRepository locationEntityRepository, StructureEntityRepository structureEntityRepository) {
        this.locationEntityRepository = locationEntityRepository;
        this.structureEntityRepository = structureEntityRepository;
    }

    public List<LocationEntity> findAll() {
        return this.locationEntityRepository.findAll();
    }

    public LocationEntity findById(Integer codeLocation) {
        Optional<LocationEntity> locationEntity = this.locationEntityRepository.findById(codeLocation);
        if(locationEntity.isPresent()){
            return locationEntity.get();
        } else{
            throw new RuntimeException("Location does not exist");
        }
    }

    @Transactional
    public void create(LocationEntity locationEntity) {
        Optional<LocationEntity> locationEntities = this.locationEntityRepository
                .findById(locationEntity.getCodeLocation());
        if (!locationEntities.isPresent()) {
            this.locationEntityRepository.save(locationEntity);
        } else {
            throw new RuntimeException("The Country Entity already exists");
        }
    }

    @Transactional
    public void update(LocationEntity locationEntity) {
        Optional<LocationEntity> locationEntities = this.locationEntityRepository
                .findById(locationEntity.getCodeLocation());
        if (locationEntities.isPresent()) {
            this.locationEntityRepository.save(locationEntity);
        } else {
            throw new RuntimeException("An error has occurred in the product update");
        }
    }

    @Transactional
    public void delete(LocationEntity locationEntity) {
        Optional<LocationEntity> locationEntities = this.locationEntityRepository
                .findById(locationEntity.getCodeLocation());
        if (locationEntities.isPresent()) {
            this.locationEntityRepository.delete(locationEntity);
        } else {
            throw new RuntimeException("The Country Entity does not exist");
        }
    }

}


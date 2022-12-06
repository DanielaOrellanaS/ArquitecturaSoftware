package com.banquito.corepasivos.general.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.general.model.LocationEntity;
import com.banquito.corepasivos.general.repository.LocationEntityRepository;

@Service
public class LocationEntityService {
    private final LocationEntityRepository locationEntityRepository;

    public LocationEntityService(LocationEntityRepository locationEntityRepository) {
        this.locationEntityRepository = locationEntityRepository;
    }

    @Transactional
    public void create(LocationEntity locationEntity) {
        List<LocationEntity> locationEntities = this.locationEntityRepository
                .findByCodeLocation(locationEntity.getCodeLocation());
        if (locationEntities.isEmpty()) {
            this.locationEntityRepository.save(locationEntity);
        } else {
            throw new RuntimeException("The Country Entity already exists");
        }
    }

    @Transactional
    public void update(LocationEntity locationEntity) {
        List<LocationEntity> locationEntities = this.locationEntityRepository
                .findByCodeLocation(locationEntity.getCodeLocation());
        if (!locationEntities.isEmpty() && locationEntities.size() == 1) {
            this.locationEntityRepository.save(locationEntity);
        } else {
            throw new RuntimeException("An error has occurred in the product update");
        }
    }

    @Transactional
    public void delete(LocationEntity locationEntity) {
        List<LocationEntity> locationEntities = this.locationEntityRepository
                .findByCodeLocation(locationEntity.getCodeLocation());
        if (!locationEntities.isEmpty()) {
            this.locationEntityRepository.delete(locationEntity);
        } else {
            throw new RuntimeException("The Country Entity does not exist");
        }
    }

    public List<LocationEntity> findAll() {
        return this.locationEntityRepository.findAll();
    }
}

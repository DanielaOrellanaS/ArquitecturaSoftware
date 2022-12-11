package com.banquito.corepasivos.general.service;

import java.util.List;
import java.util.Optional;

import javax.tools.DocumentationTool.Location;
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

    public List<LocationEntity> findAll() {
        return this.locationEntityRepository.findAll();
    }

    public LocationEntity findById(Integer codeLocation) {
        Optional<LocationEntity> locationEntity = this.locationEntityRepository.findById(codeLocation);
        if (locationEntity.isPresent()) {
            return locationEntity.get();
        } else {
            throw new RuntimeException("Location does not exist");
        }
    }

    public List<LocationEntity> findByLevel(Integer lvl) {
        try {
            return this.locationEntityRepository.findByLevel(lvl);
        } catch (Exception e) {
            throw new RuntimeException("Location does not exist");
        }
    }

    public List<LocationEntity> findByCountry(String country) {
        List<LocationEntity> locationEntities = this.locationEntityRepository.findByName(country);
        if(locationEntities.isEmpty()){
            return this.locationEntityRepository.findByName(country);
        } else {
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
            throw new RuntimeException("Location Entity already exists");
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
            throw new RuntimeException("The location does not exist");
        }
    }

    @Transactional
    public void deleteByCode(Integer codeLocation) {

        try {
            this.locationEntityRepository.deleteById(codeLocation);
        } catch (Exception e) {
            throw new RuntimeException("Location does not exist");
        }
    }

}

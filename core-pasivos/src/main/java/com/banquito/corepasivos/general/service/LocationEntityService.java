package com.banquito.corepasivos.general.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.general.model.LocationEntity;
import com.banquito.corepasivos.general.model.StructureEntity;
import com.banquito.corepasivos.general.repository.LocationEntityRepository;

import net.minidev.json.JSONObject;

@Service
public class LocationEntityService {
    private final LocationEntityRepository locationEntityRepository;
    private final StructureEntityService structureEntityService;

    public LocationEntityService(LocationEntityRepository locationEntityRepository,
            StructureEntityService structureEntityService) {
        this.locationEntityRepository = locationEntityRepository;
        this.structureEntityService = structureEntityService;
    }

    public List<LocationEntity> findAll() {
        List<LocationEntity> a = this.locationEntityRepository.findAll();
        return a;
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

    /*
     * public List<LocationEntity> findByCodeLocationParent(Integer
     * codeLocationParent,String codeCountryEntity, Integer level) {
     * try {
     * return
     * this.locationEntityRepository.findByCodeLocationParent(codeLocationParent,
     * codeCountryEntity,level);
     * } catch (Exception e) {
     * throw new RuntimeException("Location does not exist");
     * }
     * }
     */

    public List<LocationEntity> findByCountry(String country) {
        List<LocationEntity> locationEntities = this.locationEntityRepository.findByName(country);
        if (locationEntities.isEmpty()) {
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

    public List<JSONObject> search(String country) {
        List<StructureEntity> structure = this.structureEntityService.findAllByCodeCountry(country);

        List<LocationEntity> level_1 = this.locationEntityRepository.findByCodeCountryEntityAndLevel(country,
                structure.get(0).getPk().getLevel());
        List<JSONObject> jsonLevel_1 = new ArrayList<JSONObject>();
        for (LocationEntity location_1 : level_1) {
            List<LocationEntity> level_2 = this.locationEntityRepository
                    .findByCodeCountryEntityAndLevelAndCodeLocationParent(country, structure.get(1).getPk().getLevel(),
                            location_1.getCodeLocation());
            List<JSONObject> jsonLevel_2 = new ArrayList<JSONObject>();
            JSONObject objectStructure_1 = new JSONObject();
            for (LocationEntity location_2 : level_2) {
                List<LocationEntity> level_3 = this.locationEntityRepository
                        .findByCodeCountryEntityAndLevelAndCodeLocationParent(country,
                                structure.get(2).getPk().getLevel(), location_2.getCodeLocation());
                List<JSONObject> jsonLevel_3 = new ArrayList<JSONObject>();
                JSONObject objectStructure_2 = new JSONObject();
                System.out.println(
                        "qwewqrew  " + location_2.getCodeLocation() + "  " + structure.get(2).getPk().getLevel());
                for (LocationEntity location_3 : level_3) {
                    JSONObject objectStructure_3 = new JSONObject();
                    objectStructure_3.put("codeLocation",
                            location_3.getCodeLocation() + "  " + structure.get(2).getPk().getLevel());
                    objectStructure_3.put("name", location_3.getName());
                    jsonLevel_3.add(objectStructure_3);
                }
                objectStructure_2.put("codeLocation", location_2.getCodeLocation());
                objectStructure_2.put("name", location_2.getName());
                objectStructure_2.put(structure.get(2).getName(), jsonLevel_3);
                jsonLevel_2.add(objectStructure_2);
            }
            objectStructure_1.put("codeLocation", location_1.getCodeLocation());
            objectStructure_1.put("name", location_1.getName());
            objectStructure_1.put(structure.get(1).getName(), jsonLevel_2);
            jsonLevel_1.add(objectStructure_1);
        }

        return jsonLevel_1;
    }

}

package com.banquito.corepasivos.general.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.general.model.LocationEntity;

@Repository
public interface LocationEntityRepository extends JpaRepository<LocationEntity, Integer> {

    List<LocationEntity> findByName(String name);

    List<LocationEntity> findByLevel(Integer name);

    List<LocationEntity> findByCodeCountryEntityLike(String codeCountryEntity);

    List<LocationEntity> findByCodeCountryEntityAndLevelAndCodeLocationParent(String codeCountryEntity, Integer level,
            Integer codeLocationParent);

    List<LocationEntity> findByCodeCountryEntityAndLevel(String codeCountryEntity, Integer level);

}
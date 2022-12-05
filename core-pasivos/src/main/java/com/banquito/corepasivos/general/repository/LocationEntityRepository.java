package com.banquito.corepasivos.general.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.general.model.LocationEntity;

@Repository
public interface LocationEntityRepository {
    /*List<LocationEntity> findByCodeLocation(LocationEntityPK codeLocation);

    List<LocationEntity> findByCodeCountry(LocationEntityPK codeCountry);

    List<LocationEntity> findByName(LocationEntityPK name);*/
}
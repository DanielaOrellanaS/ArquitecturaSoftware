package com.banquito.corepasivos.general.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.general.model.LocationEntity;
import com.banquito.corepasivos.general.model.LocationEntityPK;

public interface LocationEntityRepository extends JpaRepository<LocationEntity, LocationEntityPK>{
    
}
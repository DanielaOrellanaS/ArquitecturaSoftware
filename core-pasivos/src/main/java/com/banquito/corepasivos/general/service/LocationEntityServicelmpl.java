package com.banquito.corepasivos.general.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.general.model.LocationEntity;
import com.banquito.corepasivos.general.repository.LocationEntityRepository;

@Service
public class LocationEntityServicelmpl implements LocationEntityService{
    @Autowired
    LocationEntityRepository locationEntityRepository;

    @Override
    public List<LocationEntity> getAllLocationEntities() {
        return locationEntityRepository.findAll();
    }
}

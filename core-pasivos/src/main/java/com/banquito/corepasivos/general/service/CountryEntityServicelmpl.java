package com.banquito.corepasivos.general.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.general.model.CountryEntity;
import com.banquito.corepasivos.general.repository.CountryEntityRepository;

@Service
public class CountryEntityServicelmpl implements CountryEntityService {

    @Autowired
    CountryEntityRepository countryEntityRepository;

    @Override
    public List<CountryEntity> getAllCountryEntities() {
        return countryEntityRepository.findAll();
    }

}

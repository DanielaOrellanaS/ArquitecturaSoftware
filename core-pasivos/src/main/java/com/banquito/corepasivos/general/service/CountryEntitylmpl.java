package com.banquito.corepasivos.general.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.banquito.corepasivos.general.model.CountryEntity;
import com.banquito.corepasivos.general.repository.CountryEntityRepository;

public class CountryEntitylmpl implements CountryEntityService {

    @Autowired
    CountryEntityRepository countryEntityRepository;

    @Override
    public List<CountryEntity> getAllCountryEntities() {
        return countryEntityRepository.findAll();
    }

}

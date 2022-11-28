package com.banquito.corepasivos.general.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.banquito.corepasivos.general.model.CountryEntity;
import com.banquito.corepasivos.general.repository.CountryEntityRepository;

public class CountryEntitylmpl implements CountryEntityService {

    @Autowired
    private CountryEntityRepository countryEntityRepository;

    @Override
    public CountryEntity createCountryEntity(CountryEntity countryEntity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CountryEntity> readCountryEntity() {
        // TODO Auto-generated method stub
        return this.countryEntityRepository.findAll();
    }

    @Override
    public CountryEntity readCountryEntityByCode(String codeCountry) {
        // TODO Auto-generated method stub
        return this.countryEntityRepository.findByCodeCountry(codeCountry).get(0);
    }

    @Override
    public CountryEntity updateCountryEntity(CountryEntity countryEntity, String codeCountry) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteCountryEntity(String codeCountry) {
        // TODO Auto-generated method stub

    }

}

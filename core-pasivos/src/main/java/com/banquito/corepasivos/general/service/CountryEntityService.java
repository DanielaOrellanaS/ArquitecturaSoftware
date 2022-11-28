package com.banquito.corepasivos.general.service;

import java.util.List;

import com.banquito.corepasivos.general.model.CountryEntity;

public interface CountryEntityService {
    CountryEntity createCountryEntity(CountryEntity countryEntity);

    List<CountryEntity> readCountryEntity();

    CountryEntity readCountryEntityByCode(String codeCountry);

    CountryEntity updateCountryEntity(CountryEntity countryEntity, String codeCountry);

    void deleteCountryEntity(String codeCountry);
}

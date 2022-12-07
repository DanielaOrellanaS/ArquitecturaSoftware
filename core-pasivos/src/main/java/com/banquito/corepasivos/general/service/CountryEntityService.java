package com.banquito.corepasivos.general.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.general.model.CountryEntity;
import com.banquito.corepasivos.general.repository.CountryEntityRepository;

@Service
public class CountryEntityService {

    private final CountryEntityRepository countryEntityRepository;

    public CountryEntityService(CountryEntityRepository countryEntityRepository) {
        this.countryEntityRepository = countryEntityRepository;
    }

    public List<CountryEntity> findAll() {
        return this.countryEntityRepository.findAll();
    }

    public CountryEntity findById(String countryEntity) {
        Optional<CountryEntity> optional = this.countryEntityRepository.findById(countryEntity);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Country not found");
        }

    }

    @Transactional
    public void create(CountryEntity countryEntity) {
        Optional<CountryEntity> optional = this.countryEntityRepository.findById(countryEntity.getCodeCountry());
        if (optional.isPresent()) {
            throw new RuntimeException("Country already exist");
        } else {
            this.countryEntityRepository.save(countryEntity);
        }
    }

    @Transactional
    public void update(CountryEntity countryEntity) {
        Optional<CountryEntity> optional = this.countryEntityRepository.findById(countryEntity.getCodeCountry());
        if (optional.isPresent()) {
            this.countryEntityRepository.save(countryEntity);
        } else {
            throw new RuntimeException("Not found");
        }
    }

    @Transactional
    public void delete(CountryEntity countryEntity) {
        Optional<CountryEntity> optional = this.countryEntityRepository.findById(countryEntity.getCodeCountry());
        if (optional.isPresent()) {
            this.countryEntityRepository.delete(countryEntity);
        } else {
            throw new RuntimeException("Not found");
        }
    }

}

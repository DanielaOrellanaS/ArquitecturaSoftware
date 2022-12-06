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

    // CRUD Literal 3
    @Transactional
    public void create(CountryEntity countryEntity) {
        List<CountryEntity> countryEntities = this.countryEntityRepository
                .findByCodeCountry(countryEntity.getCodeCountry());
        if (countryEntities.isEmpty()) {
            this.countryEntityRepository.save(countryEntity);
        } else {
            throw new RuntimeException("The Country Entity already exists");
        }
    }

    @Transactional
    public void update(CountryEntity countryEntity) {
        List<CountryEntity> countryEntities = this.countryEntityRepository
                .findByCodeCountry(countryEntity.getCodeCountry());
        if (!countryEntities.isEmpty() && countryEntities.size() == 1) {
            this.countryEntityRepository.save(countryEntity);
        } else {
            throw new RuntimeException("An error has occurred in the product update");
        }
    }

    @Transactional
    public void delete(CountryEntity countryEntity) {
        List<CountryEntity> countryEntities = this.countryEntityRepository
                .findByCodeCountry(countryEntity.getCodeCountry());
        if (!countryEntities.isEmpty()) {
            this.countryEntityRepository.delete(countryEntity);
        } else {
            throw new RuntimeException("The Country Entity does not exist");
        }
    }

    public List<CountryEntity> findAll() {
        return this.countryEntityRepository.findAll();
    }

    public Optional<CountryEntity> findById(String countryEntity) {
        try {
            return this.countryEntityRepository.findById(countryEntity);
        } catch (Exception e) {
            throw new RuntimeException("The Country Entity does not exist");
        }

    }
}

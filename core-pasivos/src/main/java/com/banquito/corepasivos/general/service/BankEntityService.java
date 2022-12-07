package com.banquito.corepasivos.general.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.general.model.BankEntity;
import com.banquito.corepasivos.general.model.BankEntityPK;
import com.banquito.corepasivos.general.repository.BankEntityRepository;

@Service
public class BankEntityService {
    private final BankEntityRepository bankEntityRepository;

    public BankEntityService(BankEntityRepository bankEntityRepository) {
        this.bankEntityRepository = bankEntityRepository;
    }

    public List<BankEntity> findAll() {
        return this.bankEntityRepository.findAll();
    }

    public BankEntity findById(BankEntityPK pk) {
        Optional<BankEntity> optional = this.bankEntityRepository.findById(pk);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Bank not found");
        }
    }

    // CRUD
    @Transactional
    public void create(BankEntity bankEntity) {
        Optional<BankEntity> optional = this.bankEntityRepository.findById(bankEntity.getPk());
        if (optional.isPresent()) {
            throw new RuntimeException("The Bank Entity already exists");
        } else {
            this.bankEntityRepository.save(bankEntity);
        }
    }

    @Transactional
    public void update(BankEntity bankEntity) {
        Optional<BankEntity> optional = this.bankEntityRepository.findById(bankEntity.getPk());
        if (optional.isPresent()) {
            this.bankEntityRepository.save(bankEntity);
        } else {
            throw new RuntimeException("Not found");
        }
    }

    @Transactional
    public void delete(BankEntity bankEntity) {
        Optional<BankEntity> optional = this.bankEntityRepository.findById(bankEntity.getPk());
        if (optional.isPresent()) {
            this.bankEntityRepository.delete(bankEntity);
        } else {
            throw new RuntimeException("Not found");
        }
    }

}

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

    // CRUD
    @Transactional
    public void create(BankEntity bankEntity) {
        List<BankEntity> bankEntities = this.bankEntityRepository
                .findByPkEntityBankCode(bankEntity.getPk().getEntityBankCode());
        if (bankEntities.isEmpty()) {
            this.bankEntityRepository.save(bankEntity);
        } else {
            throw new RuntimeException("The Bank Entity already exists");
        }
    }

    @Transactional
    public void update(BankEntity bankEntity) {
        List<BankEntity> bankEntities = this.bankEntityRepository
                .findByPkEntityBankCode(bankEntity.getPk().getEntityBankCode());
        if (!bankEntities.isEmpty()) {
            this.bankEntityRepository.save(bankEntity);
        } else {
            throw new RuntimeException("An error has occurred in the BankEntity update");
        }
    }

    @Transactional
    public void delete(BankEntity bankEntity) {
        List<BankEntity> bankEntities = this.bankEntityRepository
                .findByPkEntityBankCode(bankEntity.getPk().getEntityBankCode());
        if (!bankEntities.isEmpty()) {
            this.bankEntityRepository.delete(bankEntity);
        } else {
            throw new RuntimeException("The Bank Entity does not exist");
        }
    }

    // Servicios literal 1
    public List<BankEntity> findAll() {
        return this.bankEntityRepository.findAll();
    }

    public Optional<BankEntity> findById(BankEntityPK bankEntityPK) {
        try {
            return this.bankEntityRepository.findById(bankEntityPK);
        } catch (Exception e) {
            throw new RuntimeException("The Bank Entity does not exist");
        }

    }

}

package com.banquito.corepasivos.general.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.general.model.BankEntity;
import com.banquito.corepasivos.general.repository.BankEntityRepository;

@Service
public class BankEntityService {
    private final BankEntityRepository bankEntityRepository;

    public BankEntityService(BankEntityRepository bankEntityRepository) {
        this.bankEntityRepository = bankEntityRepository;
    }

    @Transactional
    public void register(BankEntity bankEntity) {
        List<BankEntity> bankEntities = this.bankEntityRepository.findByEntityBankCode(bankEntity.findPk());
        if (bankEntities.isEmpty()) {
            this.bankEntityRepository.save(bankEntity);
        } else {
            throw new RuntimeException("Bank entity already exist");
        }
    }

    @Transactional
    public void delete(String entityBankCode) {
        List<BankEntity> bankEntities = this.bankEntityRepository.findByEntityBankCode(null);
        if (bankEntities.isEmpty()) {
            this.bankEntityRepository.saveAll(bankEntities);
        } else {
            throw new RuntimeException("Bank entity already exist");
        }
    }

}

package com.banquito.corepasivos.general.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.banquito.corepasivos.general.model.BankEntity;
import com.banquito.corepasivos.general.model.BankEntityPK;
import com.banquito.corepasivos.general.repository.BankEntityRepository;

public class BankEntitylmpl implements BankEntityService {

    @Autowired
    private BankEntityRepository bankEntityRepository;

    @Override
    public BankEntity createBankEntity(BankEntity bankEntity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BankEntity> readAllBankEntities() {
        // TODO Auto-generated method stub
        return this.bankEntityRepository.findAll();
    }

    @Override
    public List<BankEntity> readEntityBankCode(String entityBankCode) {
        // TODO Auto-generated method stub
        return this.bankEntityRepository.findByEntityBankCode(entityBankCode);
    }

    @Override
    public List<BankEntity> readInternationalBankCode(String internationalBankCode) {
        // TODO Auto-generated method stub
        return this.bankEntityRepository.findByInternationalBankCode(internationalBankCode);
    }

    @Override
    public BankEntity updateBankEntity(BankEntity bankEntity, BankEntityPK bankEntityPK) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteBankEntity(BankEntityPK bankEntityPK) {
        // TODO Auto-generated method stub

    }

}

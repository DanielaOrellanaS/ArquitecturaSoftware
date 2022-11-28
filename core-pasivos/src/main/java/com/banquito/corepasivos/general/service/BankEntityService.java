package com.banquito.corepasivos.general.service;

import java.util.List;

import com.banquito.corepasivos.general.model.BankEntity;
import com.banquito.corepasivos.general.model.BankEntityPK;

public interface BankEntityService {
    BankEntity createBankEntity(BankEntity bankEntity);

    List<BankEntity> readAllBankEntities();

    List<BankEntity> readEntityBankCode(String entityBankCode);

    List<BankEntity> readInternationalBankCode(String internationalBankCode);

    BankEntity updateBankEntity(BankEntity bankEntity, BankEntityPK bankEntityPK);

    void deleteBankEntity(BankEntityPK bankEntityPK);
}

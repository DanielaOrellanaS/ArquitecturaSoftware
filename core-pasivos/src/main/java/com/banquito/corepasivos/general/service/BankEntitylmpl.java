package com.banquito.corepasivos.general.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.banquito.corepasivos.general.model.BankEntity;
import com.banquito.corepasivos.general.repository.BankEntityRepository;

public class BankEntitylmpl implements BankEntityService {

    @Autowired
    BankEntityRepository bankEntityRepository;

    @Override
    public List<BankEntity> getAllBankEntities() {
        return bankEntityRepository.findAll();
    }

}

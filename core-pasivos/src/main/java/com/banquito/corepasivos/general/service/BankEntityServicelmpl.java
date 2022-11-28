package com.banquito.corepasivos.general.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.general.model.BankEntity;
import com.banquito.corepasivos.general.repository.BankEntityRepository;

@Service
public class BankEntityServicelmpl implements BankEntityService {

    @Autowired
    BankEntityRepository bankEntityRepository;

    @Override
    public List<BankEntity> getAllBankEntities() {
        return bankEntityRepository.findAll();
    }

}

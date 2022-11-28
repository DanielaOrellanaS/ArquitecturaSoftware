package com.banquito.corepasivos.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.account.model.AccountAssociatedService;
import com.banquito.corepasivos.account.repository.AccountAssociatedServiceRepository;

@Service
public class AccountAssociatedServiceServiceImpl implements AccountAssociatedServiceService {

    @Autowired
    AccountAssociatedServiceRepository accountAssociatedServiceRepository;

    @Override
    public List<AccountAssociatedService> getAllAccountAssociatedServices() {
        return accountAssociatedServiceRepository.findAll();
    }
}

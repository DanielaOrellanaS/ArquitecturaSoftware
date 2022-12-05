package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.model.AccountAssociatedService;
import com.banquito.corepasivos.account.repository.AccountAssociatedServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountAssociatedServiceService {
    private final AccountAssociatedServiceRepository accountAssociatedServiceRepository;

    public AccountAssociatedServiceService(AccountAssociatedServiceRepository accountAssociatedServiceRepository) {
        this.accountAssociatedServiceRepository = accountAssociatedServiceRepository;
    }

    public List<AccountAssociatedService> findAll(){
        return this.accountAssociatedServiceRepository.findAll();
    }
}

package com.banquito.corepasivos.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.account.model.AccountClient;
import com.banquito.corepasivos.account.repository.AccountClientRepository;

@Service
public class AccountClientServiceImpl implements AccountClientService {

    @Autowired
    AccountClientRepository accountClientRepository;

    @Override
    public List<AccountClient> findAllAccountClient() {
        return accountClientRepository.findAll();
    }
}

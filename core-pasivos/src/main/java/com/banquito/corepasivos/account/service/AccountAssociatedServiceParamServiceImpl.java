package com.banquito.corepasivos.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.account.model.AccountAssociatedServiceParam;
import com.banquito.corepasivos.account.repository.AccountAssociatedServiceParamRepository;

@Service
public class AccountAssociatedServiceParamServiceImpl implements AccountAssociatedServiceParamService {

    @Autowired
    AccountAssociatedServiceParamRepository accountAssociatedServiceParamRepository;

    @Override
    public List<AccountAssociatedServiceParam> getAllAccountAssociatedServiceParams() {
        return accountAssociatedServiceParamRepository.findAll();
    }
}

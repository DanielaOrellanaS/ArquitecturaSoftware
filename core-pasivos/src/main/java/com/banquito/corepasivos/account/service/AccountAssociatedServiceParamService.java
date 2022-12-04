package com.banquito.corepasivos.account.service;

import com.banquito.corepasivos.account.model.AccountAssociatedServiceParam;
import com.banquito.corepasivos.account.repository.AccountAssociatedServiceParamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountAssociatedServiceParamService {

    private final AccountAssociatedServiceParamRepository accountAssociatedServiceParamRepository;

    public AccountAssociatedServiceParamService(AccountAssociatedServiceParamRepository accountAssociatedServiceParamRepository) {
        this.accountAssociatedServiceParamRepository = accountAssociatedServiceParamRepository;
    }

    public List<AccountAssociatedServiceParam> findAllAccountAssociatedServiceParams() {
        return accountAssociatedServiceParamRepository.findAll();
    }
}

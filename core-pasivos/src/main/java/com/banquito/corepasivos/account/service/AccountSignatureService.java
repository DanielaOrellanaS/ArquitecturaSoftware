package com.banquito.corepasivos.account.service;

import com.banquito.corepasivos.account.model.AccountSignature;
import com.banquito.corepasivos.account.repository.AccountSignatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountSignatureService {

    private final AccountSignatureRepository accountSignatureRepository;

    public AccountSignatureService(AccountSignatureRepository accountSignatureRepository) {
        this.accountSignatureRepository = accountSignatureRepository;
    }

    public List<AccountSignature> findAllAccountSignatures(){
        return accountSignatureRepository.findAll();
    }
    
}

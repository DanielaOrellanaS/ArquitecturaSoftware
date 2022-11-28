package com.banquito.corepasivos.account.service;

import com.banquito.corepasivos.account.model.AccountSignature;
import com.banquito.corepasivos.account.repository.AccountSignatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountSignatureServiceImpl implements AccountSignatureService {

    @Autowired
    AccountSignatureRepository accountSignatureRepository ;

    @Override
    public List<AccountSignature> getAllAccountSignatures(){
        return accountSignatureRepository.findAll();
    }
    
}

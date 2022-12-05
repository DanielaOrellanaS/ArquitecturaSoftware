package com.banquito.corepasivos.account.services;

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

    public List<AccountSignature> findAll(){
        return this.accountSignatureRepository.findAll();
    }

    public List<AccountSignature> findByCodeAccount(String code){
        List <AccountSignature> accountSignatures = this.accountSignatureRepository.findByPkCodelocalaccount(code);
        if(!accountSignatures.isEmpty()){
            return accountSignatures;
        } else{
            return null;
        }
    }
}

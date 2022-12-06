package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.model.AccountSignature;
import com.banquito.corepasivos.account.model.AccountSignaturePK;
import com.banquito.corepasivos.account.repository.AccountRepository;
import com.banquito.corepasivos.account.repository.AccountSignatureRepository;
import com.banquito.corepasivos.client.repository.ClientRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class AccountSignatureService {
    private final AccountSignatureRepository accountSignatureRepository;
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public AccountSignatureService(AccountSignatureRepository accountSignatureRepository,
            AccountRepository accountRepository,
            ClientRepository clientRepository) {
        this.accountSignatureRepository = accountSignatureRepository;
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    public List<AccountSignature> findAll() {
        return this.accountSignatureRepository.findAll();
    }

    public List<AccountSignature> findByCodeLocalAccount(String code) {
        List<AccountSignature> accountSignatures = this.accountSignatureRepository.findByPkCodelocalaccount(code);
        if (!accountSignatures.isEmpty()) {
            return accountSignatures;
        } else {
            throw new RuntimeException("The entry code does not belong to an account");
        }
    }

    public List<AccountSignature> findByCodeInternationalAccount(String code) {
        List<AccountSignature> accountSignatures = this.accountSignatureRepository
                .findByPkCodeinternationalaccount(code);
        if (!accountSignatures.isEmpty()) {
            return accountSignatures;
        } else {
            throw new RuntimeException("The entry code does not belong to an account");
        }
    }

    @Transactional
    public void register(AccountSignature accountSignature) {
        boolean existClient = this.clientRepository
                .existsByPkIdentification(accountSignature.getPk().getIdentification());

        boolean existeAccount = this.accountRepository
                .existsByPkCodelocalaccount(accountSignature.getPk().getCodelocalaccount());

        List<AccountSignaturePK> accountSignaturePKs = this.accountSignatureRepository
                .findByPkAccountsignature(accountSignature.getPk());

        List<AccountSignature> accountSignaturesReferences = this.accountSignatureRepository
                .findBySignatureReference(accountSignature.getSignatureReference());

        if (existeAccount && accountSignaturesReferences.isEmpty() && existClient && accountSignaturePKs.isEmpty()) {
            this.accountSignatureRepository.save(accountSignature);
        } else {
            throw new RuntimeException("The entry data is incorrect");
        }
    }

    @Transactional
    public void delete(String codeAccount, String identification) {
        List<AccountSignature> accountSignatures = this.accountSignatureRepository
                .findByPkCodelocalaccount(codeAccount);
        for (AccountSignature accountSignature : accountSignatures) {
            if (accountSignature.getPk().getIdentification().equals(identification)) {
                accountSignature.setStatus("INA");
                this.accountSignatureRepository.save(accountSignature);
            }
        }
        if (accountSignatures.isEmpty())
            throw new RuntimeException("The entry code does not belong to an account");
    }
}

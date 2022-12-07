package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.model.AccountSignature;
import com.banquito.corepasivos.account.model.AccountSignaturePK;
import com.banquito.corepasivos.account.repository.AccountRepository;
import com.banquito.corepasivos.account.repository.AccountSignatureRepository;
import com.banquito.corepasivos.client.repository.ClientRepository;

import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.ArrayList;
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

    public List<AccountSignature> findByIdentification(String identification) {
        boolean existClient = this.clientRepository
                .existsByPkIdentification(identification);
        List<AccountSignature> accountSignatures = this.accountSignatureRepository
                .findByPkIdentification(identification);

        if (existClient) {
            if (accountSignatures.isEmpty()) {
                throw new RuntimeException("The client does not have any account signature register");
            } else {
                return accountSignatures;
            }
        } else {
            throw new RuntimeException("The client does not exist");
        }
    }

    public List<AccountSignature> findByRole(String identification, String role) {
        List<AccountSignature> accountSignatures = findByIdentification(identification);
        List<AccountSignature> accountSignaturesAux = new ArrayList<>();
        for (AccountSignature accountSignature : accountSignatures) {
            if (accountSignature.getRole().equals(role)) {
                accountSignaturesAux.add(accountSignature);
            }
        }
        if (accountSignaturesAux.isEmpty()) {
            throw new RuntimeException("This account does not have the entry role");
        }
        return accountSignaturesAux;
    }

    public List<AccountSignature> findByStatus(String identification, String status) {
        List<AccountSignature> accountSignatures = findByIdentification(identification);
        List<AccountSignature> accountSignaturesAux = new ArrayList<>();
        for (AccountSignature accountSignature : accountSignatures) {
            if (accountSignature.getStatus().equals(status)) {
                accountSignaturesAux.add(accountSignature);
            }
        }
        if (accountSignaturesAux.isEmpty()) {
            throw new RuntimeException("This account does not have the entry status");
        }
        return accountSignaturesAux;
    }

    @Transactional
    public void register(AccountSignature accountSignature) {
        boolean existClient = this.clientRepository
                .existsByPkIdentification(accountSignature.getPk().getIdentification());

        boolean existAccount = this.accountRepository
                .existsByPkCodelocalaccount(accountSignature.getPk().getCodelocalaccount());

        List<AccountSignature> accountSignaturePKs = this.accountSignatureRepository
                .findByPk(accountSignature.getPk());

        List<AccountSignature> accountSignaturesReferences = this.accountSignatureRepository
                .findBySignatureReference(accountSignature.getSignatureReference());

        if (existAccount && accountSignaturesReferences.isEmpty() && existClient && accountSignaturePKs.isEmpty()) {
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
                if (accountSignature.getStatus().equals("INA")) {
                    throw new RuntimeException("The account is already deleted");
                } else {
                    accountSignature.setStatus("INA");
                    this.accountSignatureRepository.save(accountSignature);
                }
            }
        }
        if (accountSignatures.isEmpty()) {
            throw new RuntimeException("The entry code does not belong to an account");
        }
    }
}
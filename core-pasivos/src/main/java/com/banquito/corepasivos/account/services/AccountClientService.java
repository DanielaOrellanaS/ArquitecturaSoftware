package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.model.AccountClient;
import com.banquito.corepasivos.account.repository.AccountClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountClientService {
    private final AccountClientRepository accountClientRepository;

    public AccountClientService(AccountClientRepository accountClientRepository) {
        this.accountClientRepository = accountClientRepository;
    }

    @Transactional
    public AccountClient save(AccountClient accountClient) {
        return this.accountClientRepository.save(accountClient);
    }

    public List<AccountClient> findAll() {
        List<AccountClient> accountClients = this.accountClientRepository.findAll();

        if (accountClients.isEmpty())
            throw new RuntimeException("AccountClients not found.");

        return accountClients;
    }

    public List<AccountClient> findByCodeLocalAccount(String codeLocalAccount) {
        List<AccountClient> accountsByCodeLocalAccount = this.accountClientRepository
                .findByPkCodelocalaccount(codeLocalAccount);

        if (accountsByCodeLocalAccount.isEmpty())
            throw new RuntimeException("AccountClient with code-local-account: " + codeLocalAccount + " not found.");

        return accountsByCodeLocalAccount;
    }

    public List<AccountClient> findByCodeInternationalAccount(String codeInternationalAccount) {
        List<AccountClient> accountsByCodeInternationalAccount = this.accountClientRepository
                .findByPkCodeinternationalaccount(codeInternationalAccount);

        if (accountsByCodeInternationalAccount.isEmpty())
            throw new RuntimeException(
                    "AccountClient with code-international-account: " + codeInternationalAccount + " not found.");

        return accountsByCodeInternationalAccount;
    }

    public List<AccountClient> findByIndentificationType(String identificationType) {
        List<AccountClient> accountsByIdentificationType = this.accountClientRepository
                .findByPkIdentificationtype(identificationType);

        if (accountsByIdentificationType.isEmpty())
            throw new RuntimeException(
                    "AccountClient with identification-type: " + identificationType + " not found.");

        return accountsByIdentificationType;
    }

    public List<AccountClient> findByIndentification(String identification) {
        List<AccountClient> accountsByIdentification = this.accountClientRepository
                .findByPkIdentification(identification);

        if (accountsByIdentification.isEmpty())
            throw new RuntimeException(
                    "AccountClient with identification: " + identification + " not found.");

        return accountsByIdentification;
    }

    public List<AccountClient> findByStatus(String status) {
        List<AccountClient> accountsByStatus = this.accountClientRepository.findByStatus(status);

        if (accountsByStatus.isEmpty())
            throw new RuntimeException("AccountClient with status: " + status + " not found.");

        return accountsByStatus;
    }

    @Transactional
    public AccountClient updateByCodeLocalAccount(String codeLocalAccount, AccountClient accountClientDetails) {
        List<AccountClient> accountClients = this.accountClientRepository.findByPkCodelocalaccount(codeLocalAccount);

        if (accountClients.isEmpty())
            throw new RuntimeException("AccountClient with code-local-account: " + codeLocalAccount + " not found.");

        AccountClient accountClient = accountClients.get(0);
        accountClient.setStatus(accountClientDetails.getStatus());
        accountClient.setCreateDate(accountClientDetails.getCreateDate());

        return this.accountClientRepository.save(accountClient);
    }

    @Transactional
    public AccountClient updateByCodeInternationalAccount(String codeInternationalAccount,
            AccountClient accountClientDetails) {
        List<AccountClient> accountClients = this.accountClientRepository
                .findByPkCodeinternationalaccount(codeInternationalAccount);

        if (accountClients.isEmpty())
            throw new RuntimeException(
                    "AccountClient with code-international-account: " + codeInternationalAccount + " not found.");

        AccountClient accountClient = accountClients.get(0);
        accountClient.setStatus(accountClientDetails.getStatus());
        accountClient.setCreateDate(accountClientDetails.getCreateDate());

        return this.accountClientRepository.save(accountClient);
    }

    @Transactional
    public AccountClient updateByIdentification(String identification, AccountClient accountClientDetails) {
        List<AccountClient> accountClients = this.accountClientRepository
                .findByPkIdentification(identification);

        if (accountClients.isEmpty())
            throw new RuntimeException("AccountClient with identification: " + identification + " not found.");

        AccountClient accountClient = accountClients.get(0);
        accountClient.setStatus(accountClientDetails.getStatus());
        accountClient.setCreateDate(accountClientDetails.getCreateDate());

        return this.accountClientRepository.save(accountClient);
    }

    @Transactional
    public AccountClient deleteByCodeLocalAccount(String codeLocalAccount) {
        List<AccountClient> accountClients = this.accountClientRepository.findByPkCodelocalaccount(codeLocalAccount);

        if (accountClients.isEmpty())
            throw new RuntimeException(
                    "AccountClient with code-local-account: " + codeLocalAccount + " not found.");

        AccountClient accountClient = accountClients.get(0);
        accountClient.setStatus("INA");

        return this.accountClientRepository.save(accountClient);
    }

    @Transactional
    public AccountClient deleteByCodeInternationalAccount(String codeInternationalAccount) {
        List<AccountClient> accountClients = this.accountClientRepository
                .findByPkCodeinternationalaccount(codeInternationalAccount);

        if (accountClients.isEmpty())
            throw new RuntimeException(
                    "AccountClient with code-International-account: " + codeInternationalAccount + " not found.");

        AccountClient accountClient = accountClients.get(0);
        accountClient.setStatus("INA");

        return this.accountClientRepository.save(accountClient);
    }

    @Transactional
    public AccountClient deleteByIdentification(String Identification) {
        List<AccountClient> accountClients = this.accountClientRepository
                .findByPkIdentification(Identification);

        if (accountClients.isEmpty())
            throw new RuntimeException(
                    "AccountClient with identification: " + Identification + " not found.");

        AccountClient accountClient = accountClients.get(0);
        accountClient.setStatus("INA");

        return this.accountClientRepository.save(accountClient);
    }
}

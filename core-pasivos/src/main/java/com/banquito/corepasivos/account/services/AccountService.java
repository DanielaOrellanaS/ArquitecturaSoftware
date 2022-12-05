package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.model.Account;
import com.banquito.corepasivos.account.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account save(Account account) {
        return this.accountRepository.save(account);
    }

    public List<Account> findAll() {
        List<Account> accounts = this.accountRepository.findAll();

        if (accounts.isEmpty())
            throw new RuntimeException("Accounts not found.");

        return accounts;
    }

    public List<Account> findByCodeLocalAccount(String codeLocalAccount) {
        List<Account> accountsByCodeLocalAccount = this.accountRepository.findByPkCodelocalaccount(codeLocalAccount);

        if (accountsByCodeLocalAccount.isEmpty())
            throw new RuntimeException("Account with code-local-account: " + codeLocalAccount + " not found.");

        return accountsByCodeLocalAccount;
    }

    public List<Account> findByCodeInternationalAccount(String codeInternationalAccount) {
        List<Account> accountsByCodeInternationalAccount = this.accountRepository
                .findByPkCodeinternationalaccount(codeInternationalAccount);

        if (accountsByCodeInternationalAccount.isEmpty())
            throw new RuntimeException(
                    "Account with code-international-account: " + codeInternationalAccount + " not found.");

        return accountsByCodeInternationalAccount;
    }

    public List<Account> findByCodeProduct(String codeProduct) {
        List<Account> accountsByCodeProduct = this.accountRepository.findByCodeProduct(codeProduct);

        if (accountsByCodeProduct.isEmpty())
            throw new RuntimeException("Account with code-product: " + codeProduct + " not found.");

        return accountsByCodeProduct;
    }

    public List<Account> findByCodeProductType(String codeProductType) {
        List<Account> accountsByCodeProductType = this.accountRepository.findByCodeProductType(codeProductType);

        if (accountsByCodeProductType.isEmpty())
            throw new RuntimeException("Account with code-product-type: " + codeProductType + " not found.");

        return accountsByCodeProductType;
    }

    public List<Account> findByCodeBranch(String codeBranch) {
        List<Account> accountsByCodeBranch = this.accountRepository.findByCodeBranch(codeBranch);

        if (accountsByCodeBranch.isEmpty())
            throw new RuntimeException("Account with code-branch: " + codeBranch + " not found.");

        return accountsByCodeBranch;
    }

    public List<Account> findByEntityBankCode(String entityBankCode) {
        List<Account> accountsByEntityBankCode = this.accountRepository.findByEntityBankCode(entityBankCode);

        if (accountsByEntityBankCode.isEmpty())
            throw new RuntimeException("Account with entity-bank-code: " + entityBankCode + " not found.");

        return accountsByEntityBankCode;
    }

    public List<Account> findByInternationalBankCode(String internationalBankCode) {
        List<Account> accountsByInternationalBankCode = this.accountRepository
                .findByInternationalBankCode(internationalBankCode);

        if (accountsByInternationalBankCode.isEmpty())
            throw new RuntimeException(
                    "Account with International-bank-code: " + internationalBankCode + " not found.");

        return accountsByInternationalBankCode;
    }

    public List<Account> findByStatus(String status) {
        List<Account> accountsByStatus = this.accountRepository.findByStatus(status);

        if (accountsByStatus.isEmpty())
            throw new RuntimeException("Account with status: " + status + " not found.");

        return accountsByStatus;
    }

    @Transactional
    public Account updateByCodeLocalAccount(String codeLocalAccount, Account accountDetails) {
        List<Account> accounts = this.accountRepository.findByPkCodelocalaccount(codeLocalAccount);

        if (accounts.isEmpty())
            throw new RuntimeException("Account with code-local-account: " + codeLocalAccount + " not found.");

        Account account = accounts.get(0);
        account.setStatus(accountDetails.getStatus());
        account.setCreateDate(accountDetails.getCreateDate());
        account.setLastUpdateDate(accountDetails.getLastUpdateDate());
        account.setCloseDate(accountDetails.getCloseDate());
        account.setPresentBalance(accountDetails.getPresentBalance());
        account.setAvailableBalance(accountDetails.getAvailableBalance());

        return this.accountRepository.save(account);
    }

    @Transactional
    public Account updateByCodeInternationalAccount(String codeInternationalAccount, Account accountDetails) {
        List<Account> accounts = this.accountRepository.findByPkCodeinternationalaccount(codeInternationalAccount);

        if (accounts.isEmpty())
            throw new RuntimeException(
                    "Account with code-international-account: " + codeInternationalAccount + " not found.");

        Account account = accounts.get(0);
        account.setStatus(accountDetails.getStatus());
        account.setCreateDate(accountDetails.getCreateDate());
        account.setLastUpdateDate(accountDetails.getLastUpdateDate());
        account.setCloseDate(accountDetails.getCloseDate());
        account.setPresentBalance(accountDetails.getPresentBalance());
        account.setAvailableBalance(accountDetails.getAvailableBalance());

        return this.accountRepository.save(account);
    }

    @Transactional
    public Account deleteByCodeLocalAccount(String codeLocalAccount) {
        List<Account> accounts = this.accountRepository.findByPkCodelocalaccount(codeLocalAccount);

        if (accounts.isEmpty())
            throw new RuntimeException(
                    "Account with code-local-account: " + codeLocalAccount + " not found.");

        Account account = accounts.get(0);
        account.setStatus("INA");

        return this.accountRepository.save(account);
    }

    @Transactional
    public Account deleteByCodeInternationalAccount(String codeInternationalAccount) {
        List<Account> accounts = this.accountRepository.findByPkCodeinternationalaccount(codeInternationalAccount);

        if (accounts.isEmpty())
            throw new RuntimeException(
                    "Account with code-international-account: " + codeInternationalAccount + " not found.");

        Account account = accounts.get(0);
        account.setStatus("INA");

        return this.accountRepository.save(account);
    }
}

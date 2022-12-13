package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.dto.request.AccountClientCompleteReqDto;
import com.banquito.corepasivos.account.dto.request.AccountClientReqDto;
import com.banquito.corepasivos.account.dto.response.AccountClientResDto;
import com.banquito.corepasivos.account.dto.response.AccountClientResStatusDto;
import com.banquito.corepasivos.account.mapper.AccountClientMapper;
import com.banquito.corepasivos.account.model.AccountClient;
import com.banquito.corepasivos.account.model.AccountClientPK;
import com.banquito.corepasivos.account.repository.AccountClientRepository;
import com.banquito.corepasivos.account.repository.AccountRepository;
import com.banquito.corepasivos.client.repository.ClientRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountClientService {

    private final AccountClientRepository accountClientRepository;
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public AccountClientService(AccountClientRepository accountClientRepository, AccountRepository accountRepository,
            ClientRepository clientRepository) {
        this.accountClientRepository = accountClientRepository;
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public void save(AccountClientReqDto accountClientReqDto) {
        if (!accountRepository.existsByPkCodelocalaccount(accountClientReqDto.getCodeLocalAccount())
                || !accountRepository
                        .existsByPkCodeinternationalaccount(accountClientReqDto.getCodeInternationalAccount())
                || !clientRepository.existsByPkIdentification(accountClientReqDto.getIdentification()))
            throw new RuntimeException("Error while saving record.");

        AccountClient accountClient = new AccountClient();
        AccountClientPK pk = new AccountClientPK();

        pk.setCodelocalaccount(accountClientReqDto.getCodeLocalAccount());
        pk.setCodeinternationalaccount(accountClientReqDto.getCodeInternationalAccount());
        pk.setIdentificationtype(accountClientReqDto.getIdentificationType());
        pk.setIdentification(accountClientReqDto.getIdentification());

        accountClient.setPk(pk);
        accountClient.setCreateDate(new Date());
        accountClient.setStatus("ACT");

        this.accountClientRepository.save(accountClient);
    }

    public List<AccountClientResStatusDto> findById(String codeLocalAccount,
            String codeInternationalAccount) {
        List<AccountClient> accountsById = this.accountClientRepository
                .findByPkCodelocalaccountAndPkCodeinternationalaccount(codeLocalAccount, codeInternationalAccount);

        if (accountsById.isEmpty())
            throw new RuntimeException("Error while searching record");

        List<AccountClientResStatusDto> accountsResponse = new ArrayList<AccountClientResStatusDto>();

        for (AccountClient accountClient : accountsById) {
            accountsResponse.add(AccountClientMapper.mapperStatus(accountClient));
        }

        return accountsResponse;
    }

    public List<AccountClientResDto> findByStatus(String codeLocalAccount,
            String codeInternationalAccount, String status) {
        List<AccountClient> accountsByStatus = this.accountClientRepository
                .findByPkCodelocalaccountAndPkCodeinternationalaccountAndStatus(codeLocalAccount,
                        codeInternationalAccount, status);

        if (accountsByStatus.isEmpty())
            throw new RuntimeException("Error while searching record.");

        List<AccountClientResDto> accountsResponse = new ArrayList<AccountClientResDto>();

        for (AccountClient accountClient : accountsByStatus) {
            accountsResponse.add(AccountClientMapper.mapper(accountClient));
        }

        return accountsResponse;
    }

    @Transactional
    public void updateById(String codeLocalAccount, String codeInternationalAccount,
            AccountClientCompleteReqDto accountClientDetails) {
        List<AccountClient> accountClients = this.accountClientRepository
                .findByPkCodelocalaccountAndPkCodeinternationalaccount(codeLocalAccount, codeInternationalAccount);

        if (accountClients.isEmpty())
            throw new RuntimeException("Error while updating record");

        AccountClient accountClient = accountClients.get(0);
        accountClient.setStatus(accountClientDetails.getStatus());
        accountClient.setCreateDate(accountClientDetails.getCreateDate());

        this.accountClientRepository.save(accountClient);
    }

    @Transactional
    public void deleteById(String codeLocalAccount, String codeInternationalAccount) {
        List<AccountClient> accountClients = this.accountClientRepository
                .findByPkCodelocalaccountAndPkCodeinternationalaccount(codeLocalAccount, codeInternationalAccount);

        if (accountClients.isEmpty())
            throw new RuntimeException("Error while deleting record");

        AccountClient accountClient = accountClients.get(0);
        accountClient.setStatus("INA");

        this.accountClientRepository.save(accountClient);
    }
}

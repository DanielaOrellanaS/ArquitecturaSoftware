package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.dto.request.AccountSignatureCreateDto;
import com.banquito.corepasivos.account.dto.response.AccountSignatureAccountDatesDto;
import com.banquito.corepasivos.account.dto.response.AccountSignatureAccountIdentificationDto;
import com.banquito.corepasivos.account.dto.response.AccountSignatureAccountStatusDto;
import com.banquito.corepasivos.account.dto.response.AccountSignatureIdentificationDatesDto;
import com.banquito.corepasivos.account.dto.response.AccountSignatureIdentificationStatusDto;
import com.banquito.corepasivos.account.mapper.AccountSignatureMapper;
import com.banquito.corepasivos.account.model.AccountSignature;
import com.banquito.corepasivos.account.model.AccountSignaturePK;
import com.banquito.corepasivos.account.repository.AccountRepository;
import com.banquito.corepasivos.account.repository.AccountSignatureRepository;
import com.banquito.corepasivos.client.repository.ClientRepository;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public List<AccountSignatureAccountIdentificationDto> findByPk(String local, String international,
            String identificationType, String identification) {
        AccountSignaturePK accountSignaturePK = new AccountSignaturePK(local, international, identificationType,
                identification);
        List<AccountSignature> accountSignatures = this.accountSignatureRepository.findByPk(accountSignaturePK);
        List<AccountSignatureAccountIdentificationDto> accountIdentificationDtos = new ArrayList<>();
        AccountSignatureAccountIdentificationDto objDto;

        if (!accountSignatures.isEmpty()) {
            for (AccountSignature accountSignature : accountSignatures) {
                objDto = AccountSignatureMapper.responsePK(accountSignature);
                accountIdentificationDtos.add(objDto);
            }
        } else {
            throw new RuntimeException("Error while requesting information");
        }

        return accountIdentificationDtos;
    }

    public List<AccountSignatureIdentificationDatesDto> findByAccountDates(String local, String international,
            Date startDate, Date endDate) {
        List<AccountSignature> accountSignatures = this.accountSignatureRepository.findByStartDateBetween(startDate,
                endDate);
        List<AccountSignatureIdentificationDatesDto> accountSignatureDatesDtos = new ArrayList<>();
        AccountSignatureIdentificationDatesDto objDto;

        for (AccountSignature accountSignature : accountSignatures) {
            if (accountSignature.getPk().getCodelocalaccount().equals(local)
                    && accountSignature.getPk().getCodeinternationalaccount().equals(international)) {
                objDto = AccountSignatureMapper.responseIdentificationDate(accountSignature);
                accountSignatureDatesDtos.add(objDto);
            }
        }
        if (accountSignatureDatesDtos.isEmpty()) {
            throw new RuntimeException("Error while requesting information");
        } else {
            return accountSignatureDatesDtos;
        }
    }

    public List<AccountSignatureAccountDatesDto> findByIdentificationDates(String identification,
            String identificationType, Date startDate, Date endDate) {
        List<AccountSignature> accountSignatures = this.accountSignatureRepository.findByStartDateBetween(startDate,
                endDate);
        List<AccountSignatureAccountDatesDto> accountSignatureDatesDtos = new ArrayList<>();
        AccountSignatureAccountDatesDto objDto;

        for (AccountSignature accountSignature : accountSignatures) {
            if (accountSignature.getPk().getIdentification().equals(identification)
                    && accountSignature.getPk().getIdentificationtype().equals(identificationType)) {
                objDto = AccountSignatureMapper.responseAccountDates(accountSignature);
                accountSignatureDatesDtos.add(objDto);
            }
        }
        if (accountSignatureDatesDtos.isEmpty()) {
            throw new RuntimeException("Error while requesting information");
        } else {
            return accountSignatureDatesDtos;
        }
    }

    public List<AccountSignatureAccountStatusDto> findByIdentificationStatus(String identification,
            String identificationType, String status) {
        List<AccountSignature> accountSignatures = findByIdentification(identification);
        List<AccountSignatureAccountStatusDto> accountSignatureDatesDtos = new ArrayList<>();
        AccountSignatureAccountStatusDto objDto;

        for (AccountSignature accountSignature : accountSignatures) {
            if (accountSignature.getStatus().equals(status)) {
                objDto = AccountSignatureMapper.responseAccountStatus(accountSignature);
                accountSignatureDatesDtos.add(objDto);
            }
        }
        if (accountSignatureDatesDtos.isEmpty()) {
            throw new RuntimeException("Error while requesting information");
        } else {
            return accountSignatureDatesDtos;
        }
    }

    public List<AccountSignatureIdentificationStatusDto> findByAccountStatus(String local, String international,
            String status) {
        List<AccountSignature> accountSignatures = findByCodeLocalAccount(local);
        List<AccountSignatureIdentificationStatusDto> accountSignatureDatesDtos = new ArrayList<>();
        AccountSignatureIdentificationStatusDto objDto;

        for (AccountSignature accountSignature : accountSignatures) {
            if (accountSignature.getStatus().equals(status)) {
                objDto = AccountSignatureMapper.responseIdentificationStatus(accountSignature);
                accountSignatureDatesDtos.add(objDto);
            }
        }
        if (accountSignatureDatesDtos.isEmpty()) {
            throw new RuntimeException("Error while requesting information");
        } else {
            return accountSignatureDatesDtos;
        }
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

    @Transactional
    public void updateByCodeLocalAccount(String account, AccountSignature accountDetails) {
        List<AccountSignature> accountSignatures = this.accountSignatureRepository.findByPkCodelocalaccount(account);
        if (accountSignatures.isEmpty())
            throw new RuntimeException("Account with code-local-account: " + account + " not found.");

        AccountSignature accountSignature = accountSignatures.get(0);
        accountSignature.setSignatureReference(accountDetails.getSignatureReference());
        accountSignature.setRole(accountDetails.getRole());
        accountSignature.setStatus(accountDetails.getStatus());
        accountSignature.setCreateDate(accountDetails.getCreateDate());
        accountSignature.setEndDate(accountDetails.getEndDate());

        this.accountSignatureRepository.save(accountSignature);
    }

    @Transactional
    public void register(AccountSignatureCreateDto accountSignatureCreateDto) {
        AccountSignaturePK accountSignaturePK = new AccountSignaturePK(accountSignatureCreateDto.getCodelocalaccount(),
                accountSignatureCreateDto.getCodeinternationalaccount(),
                accountSignatureCreateDto.getIdentificationtype(), accountSignatureCreateDto.getIdentification());
        // SimpleDateFormat formDate = new SimpleDateFormat("yyyy-MM-dd");
        AccountSignature accountSignature = new AccountSignature();
        // boolean existAccountSignature =
        // this.accountSignatureRepository.existByPk(accountSignaturePK);

        boolean existClient = this.clientRepository
                .existsByPkIdentification(accountSignatureCreateDto.getIdentification());

        boolean existAccount = this.accountRepository
                .existsByPkCodelocalaccount(accountSignatureCreateDto.getCodelocalaccount());

        List<AccountSignature> accountSignaturePKs = this.accountSignatureRepository
                .findByPk(accountSignaturePK);

        List<AccountSignature> accountSignaturesReferences = this.accountSignatureRepository
                .findBySignatureReference(accountSignatureCreateDto.getSignatureReference());

        if (existAccount && accountSignaturesReferences.isEmpty() && existClient && accountSignaturePKs.isEmpty()) {
            accountSignature = AccountSignatureMapper.requestCreate(accountSignatureCreateDto);
            accountSignature.setStatus("ACT");
            accountSignature.setCreateDate(new Date());
            accountSignature.setStartDate(new Date());
            this.accountSignatureRepository.save(accountSignature);
        } else {
            throw new RuntimeException("The entry data is incorrect");
        }
    }

    @Transactional
    public void delete(String local, String international, String type, String identification) {
        AccountSignaturePK accountSignaturePK = new AccountSignaturePK(local, international, type, identification);
        List<AccountSignature> accountSignatures = this.accountSignatureRepository.findByPk(accountSignaturePK);

        for (AccountSignature accountSignature : accountSignatures) {
            if (accountSignature.getStatus().equals("INA")) {
                throw new RuntimeException("The account is already deleted");
            } else {
                accountSignature.setStatus("INA");
                accountSignature.setEndDate(new Date());
                this.accountSignatureRepository.save(accountSignature);
            }
        }

        if (accountSignatures.isEmpty()) {
            throw new RuntimeException("Error while deleting record");
        }
    }
}
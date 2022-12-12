package com.banquito.corepasivos.account.mapper;

import com.banquito.corepasivos.account.dto.response.AccountSignatureAccountDatesDto;
import com.banquito.corepasivos.account.dto.response.AccountSignatureAccountIdentificationDto;
import com.banquito.corepasivos.account.dto.response.AccountSignatureAccountStatusDto;
import com.banquito.corepasivos.account.dto.response.AccountSignatureIdentificationDatesDto;
import com.banquito.corepasivos.account.dto.response.AccountSignatureIdentificationStatusDto;
import com.banquito.corepasivos.account.model.AccountSignature;

public class AccountSignatureMapper {

    public static AccountSignatureAccountIdentificationDto responsePK(AccountSignature accountSignature) {
        AccountSignatureAccountIdentificationDto accountSignatureDto = new AccountSignatureAccountIdentificationDto();
        accountSignatureDto.setSignatureReference(accountSignature.getSignatureReference());
        accountSignatureDto.setRole(accountSignature.getRole());
        accountSignatureDto.setStatus(accountSignature.getStatus());
        accountSignatureDto.setStartDate(accountSignature.getStartDate());
        accountSignatureDto.setEndDate(accountSignature.getEndDate());
        return accountSignatureDto;
    }

    public static AccountSignatureIdentificationDatesDto responseIdentificationDate(AccountSignature accountSignature) {
        AccountSignatureIdentificationDatesDto accountSignatureDatesDto = new AccountSignatureIdentificationDatesDto();
        accountSignatureDatesDto.setIdentificationtype(accountSignature.getPk().getIdentificationtype());
        accountSignatureDatesDto.setIdentification(accountSignature.getPk().getIdentification());
        accountSignatureDatesDto.setSignatureReference(accountSignature.getSignatureReference());
        accountSignatureDatesDto.setRole(accountSignature.getRole());
        accountSignatureDatesDto.setStatus(accountSignature.getStatus());
        accountSignatureDatesDto.setStartDate(accountSignature.getStartDate());
        return accountSignatureDatesDto;
    }

    public static AccountSignatureAccountDatesDto responseAccountDates(AccountSignature accountSignature) {
        AccountSignatureAccountDatesDto accountSignatureAccountDatesDto = new AccountSignatureAccountDatesDto();
        accountSignatureAccountDatesDto.setCodelocalaccount(accountSignature.getPk().getCodelocalaccount());
        accountSignatureAccountDatesDto
                .setCodeinternationalaccount(accountSignature.getPk().getCodeinternationalaccount());
        accountSignatureAccountDatesDto.setSignatureReference(accountSignature.getSignatureReference());
        accountSignatureAccountDatesDto.setRole(accountSignature.getRole());
        accountSignatureAccountDatesDto.setStatus(accountSignature.getStatus());
        accountSignatureAccountDatesDto.setStartDate(accountSignature.getStartDate());
        return accountSignatureAccountDatesDto;
    }

    public static AccountSignatureIdentificationStatusDto responseIdentificationStatus(
            AccountSignature accountSignature) {
        AccountSignatureIdentificationStatusDto accountSignatureStatusDto = new AccountSignatureIdentificationStatusDto();
        accountSignatureStatusDto.setIdentificationtype(accountSignature.getPk().getIdentificationtype());
        accountSignatureStatusDto.setIdentification(accountSignature.getPk().getIdentification());
        accountSignatureStatusDto.setSignatureReference(accountSignature.getSignatureReference());
        accountSignatureStatusDto.setRole(accountSignature.getRole());
        accountSignatureStatusDto.setStartDate(accountSignature.getStartDate());
        return accountSignatureStatusDto;
    }

    public static AccountSignatureAccountStatusDto responseAccountStatus(AccountSignature accountSignature) {
        AccountSignatureAccountStatusDto accountSignatureAccountStatusDto = new AccountSignatureAccountStatusDto();
        accountSignatureAccountStatusDto.setCodelocalaccount(accountSignature.getPk().getCodelocalaccount());
        accountSignatureAccountStatusDto
                .setCodeinternationalaccount(accountSignature.getPk().getCodeinternationalaccount());
        accountSignatureAccountStatusDto.setSignatureReference(accountSignature.getSignatureReference());
        accountSignatureAccountStatusDto.setRole(accountSignature.getRole());
        accountSignatureAccountStatusDto.setStartDate(accountSignature.getStartDate());
        return accountSignatureAccountStatusDto;
    }

}

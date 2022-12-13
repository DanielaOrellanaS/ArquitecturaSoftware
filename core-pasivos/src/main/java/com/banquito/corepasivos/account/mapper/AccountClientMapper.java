package com.banquito.corepasivos.account.mapper;

import com.banquito.corepasivos.account.dto.response.AccountClientResDto;
import com.banquito.corepasivos.account.dto.response.AccountClientResStatusDto;
import com.banquito.corepasivos.account.model.AccountClient;

public class AccountClientMapper {

    public static AccountClientResStatusDto mapperStatus(AccountClient accountClient) {
        AccountClientResStatusDto accountClientResStatusDto = new AccountClientResStatusDto();

        accountClientResStatusDto.setCodeLocalAccount(accountClient.getPk().getCodelocalaccount());
        accountClientResStatusDto.setCodeInternationalAccount(accountClient.getPk().getCodeinternationalaccount());
        accountClientResStatusDto.setCreateDate(accountClient.getCreateDate());
        accountClientResStatusDto.setStatus(accountClient.getStatus());

        return accountClientResStatusDto;
    }

    public static AccountClientResDto mapper(AccountClient accountClient) {
        AccountClientResDto accountClientResDto = new AccountClientResDto();

        accountClientResDto.setCodeLocalAccount(accountClient.getPk().getCodelocalaccount());
        accountClientResDto.setCodeInternationalAccount(accountClient.getPk().getCodeinternationalaccount());
        accountClientResDto.setCreateDate(accountClient.getCreateDate());

        return accountClientResDto;
    }
}

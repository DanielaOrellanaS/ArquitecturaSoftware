package com.banquito.corepasivos.account.dto.response;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountClientResStatusDto {
    private String codeLocalAccount;
    private String codeInternationalAccount;
    private Date createDate;
    private String status;
}

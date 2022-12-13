package com.banquito.corepasivos.account.dto.request;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountClientReqDto implements Serializable {
    private String codeLocalAccount;
    private String codeInternationalAccount;
    private String identificationType;
    private String identification;
}

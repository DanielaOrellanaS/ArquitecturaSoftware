package com.banquito.corepasivos.account.dto.request;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountSignatureCreateDto implements Serializable {
    private String codelocalaccount;
    private String codeinternationalaccount;
    private String identificationtype;
    private String identification;
    private String signatureReference;
    private String role;
}

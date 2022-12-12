package com.banquito.corepasivos.account.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AccountAssociatedServiceResDto implements Serializable {

    private String codeLocalAccount;

    private String codeProduct;

    private String status;

}

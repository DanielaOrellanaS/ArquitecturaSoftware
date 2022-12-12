package com.banquito.corepasivos.account.dto.response;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountSignatureAccountDatesDto implements Serializable {
    private String codelocalaccount;
    private String codeinternationalaccount;
    private String signatureReference;
    private String role;
    private String status;
    private Date startDate;

}

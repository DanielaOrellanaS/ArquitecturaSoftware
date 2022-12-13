package com.banquito.corepasivos.account.dto.request;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountClientCompleteReqDto {
    private Date createDate;
    private String status;
}

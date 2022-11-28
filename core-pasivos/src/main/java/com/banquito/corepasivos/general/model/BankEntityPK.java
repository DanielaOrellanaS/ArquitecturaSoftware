package com.banquito.corepasivos.general.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class BankEntityPK implements Serializable{
    @Column(name = "ENITITY_BANK_CODE", length = 16, nullable = false)
    private String entityBankCode;
    @Column(name = "INTERNATIONAL_BANK_CODE", length = 16, nullable = false)
    private String internationalBankCode;
}

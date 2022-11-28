package com.banquito.corepasivos.general.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
public class BankEntityPK implements Serializable {

    @Column(name = "entity_bank_code", length = 16, nullable = false)
    private String entityBankCode;

    @Column(name = "international_bank_code", length = 16, nullable = false)
    private String internationalBankCode;
}

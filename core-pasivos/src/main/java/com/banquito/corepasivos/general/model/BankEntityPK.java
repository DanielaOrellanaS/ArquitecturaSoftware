package com.banquito.corepasivos.general.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
public class BankEntityPK implements Serializable {

    @Column(name = "entity_bank_code", length = 16, nullable = false)
    private String entityBankCode;

    @Column(name = "international_bank_code", length = 16, nullable = false)
    private String internationalBankCode;
}

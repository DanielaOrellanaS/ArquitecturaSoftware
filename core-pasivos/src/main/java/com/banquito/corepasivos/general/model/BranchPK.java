package com.banquito.corepasivos.general.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class BranchPK implements Serializable {
    @Column(name = "CODE_BRANCH", length = 3, nullable = false)
    private String codeBranch;
    @Column(name = "ENTITY_BANK_CODE", length = 16, nullable = false)
    private String entityBankCode;
    @Column(name = "INTERNATIONAL_BANL_CODE", length = 16, nullable = false)
    private String internationalBankCode;
}

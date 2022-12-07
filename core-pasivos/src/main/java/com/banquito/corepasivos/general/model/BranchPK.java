package com.banquito.corepasivos.general.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class BranchPK implements Serializable {

    @Column(name = "code_branch", length = 3, nullable = false)
    private String codebranch;

    @Column(name = "entity_bank_code", length = 16, nullable = false)
    private String entityBankCode;

    @Column(name = "international_bank_code", length = 16, nullable = false)
    private String internationalBankCode;
}

package com.banquito.corepasivos.account.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {

    @EqualsAndHashCode.Include
    @EmbeddedId
    AccountPK accountPK;

    @Column(name = "code_product", length = 32, nullable = false)
    private String codeProduct;

    @Column(name = "code_branch", length = 3, nullable = false)
    private String codeBranch;

    @Column(name = "entity_bank_code", length = 16, nullable = false)
    private String entityBankCode;

    @Column(name = "international_bank_code", length = 16, nullable = false)
    private String internationalBankCode;

    @Column(name = "status", length = 3, nullable = false)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    private Timestamp createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_date", nullable = false)
    private Timestamp lastUpdateDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "close_date", nullable = true)
    private Timestamp closeDate;

    @Column(name = "present_balance", nullable = false)
    private BigDecimal presentBalance;

    @Column(name = "available_balance", nullable = false)
    private BigDecimal availableBalance;

    public Account(AccountPK accountPK) {
        this.accountPK = accountPK;
    }
}

package com.banquito.corepasivos.account.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "ACCOUNT")
public class Account {
    @EqualsAndHashCode.Include
    @Column(name = "CODE_ACCOUNT", nullable = false)
    private Integer codeAccount;

    @Column(name = "CODE_PRODUCT", length = 32, nullable = true)
    private String codeProduct;

    @Column(name = "CODE_BRANCH", length = 3, nullable = true)
    private String codeBranch;

    @Column(name = "CODE_INTERNAL_ACCOUNT", length = 8, nullable = false)
    private String codeInternalAccount;

    @Column(name = "CODE_INTERNATIONAL_ACCOUNT", length = 16, nullable = false)
    private String codeInternationalAccount;

    @Column(name = "STATUS", length = 3, nullable = false)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false)
    private Timestamp createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATE_DATE", nullable = false)
    private Timestamp lastUpdateDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CANCEL_DATE", nullable = false)
    private Timestamp cancelDate;

    @Column(name = "PRESENT_BALANCE", scale = 17, precision = 2, nullable = false)
    private Double presentBlance;

    @Column(name = "AVAILABLE_BALANCE", scale = 17, precision = 2, nullable = false)
    private Double avalibleBalance;

    public Account(Integer codeAccount) {
        this.codeAccount = codeAccount;
    }
}

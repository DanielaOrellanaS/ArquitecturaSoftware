package com.banquito.corepasivos.account.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "ACCOUNT")
public class Account {
    @EqualsAndHashCode.Include
    @Id
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
    private Timestamp createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp lastUpdateDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp cancelDate;

    @Column(name = "PRESENT_BALANCE", scale = 17, precision = 2, nullable = false)
    private double presentBlance;

    @Column(name = "AVAILABLE_BALANCE", scale = 17, precision = 2, nullable = false)
    private double avalibleBalance;

    public Account(Integer codeAccount) {
        this.codeAccount = codeAccount;
    }
}

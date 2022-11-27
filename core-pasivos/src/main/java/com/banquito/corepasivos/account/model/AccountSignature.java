package com.banquito.corepasivos.account.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNT_SIGNATURE")
public class AccountSignature implements Serializable {
    @EmbeddedId
    private AccountSignaturePK pk;

    @Column(name = "SIGNATURE_REFERENCE", length = 2048,  nullable = false)
    private String signatureReference;

    @Column(name = "ROLE", length = 64, nullable = false)
    private String role;

    @Column(name = "STATUS", length = 3, nullable = false)
    private String status;

    @Column(name = "CREATE_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "END_DATE", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public AccountSignature(AccountSignaturePK pk) {
        this.pk = pk;
    }
}

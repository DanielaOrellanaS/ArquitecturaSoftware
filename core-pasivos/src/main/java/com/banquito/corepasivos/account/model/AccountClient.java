package com.banquito.corepasivos.account.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;

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
@Table(name = "ACCOUNT_CLIENT")
public class AccountClient implements Serializable {

    @EmbeddedId
    private AccountClientPK pk;

    @Column(name = "CREATE_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    // private Timestamp createDate;

    @Column(name = "STATUS", length = 3, nullable = false)
    private String status;

    public AccountClient(AccountClientPK pk) {
        this.pk = pk;
    }

}

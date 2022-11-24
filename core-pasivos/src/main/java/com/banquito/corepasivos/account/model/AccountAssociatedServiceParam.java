package com.banquito.corepasivos.account.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNT_ASSO_SERVICE_PARAM")
public class AccountAssociatedServiceParam {
    @EqualsAndHashCode.Include
    @EmbeddedId
    private AccountAssociatedServiceParamPK accountAssociatedServiceParamPK;

    @Column(name = "STATUS", length = 3, nullable = false)
    private String status;
    @Column(name = "TEXT_VALUE", length = 128, nullable = false)
    private String textValue;
    @Column(name = "DATE_VALUE", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp dateValue;
    @Column(name = "NUMBER_VALUE", length = 17, precision = 2, nullable = true)
    private Number numberValue;
    @Column(name = "CREATE_DATE", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createDate;
    @Column(name = "END_DATE", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp endDate;

    public AccountAssociatedServiceParam(AccountAssociatedServiceParamPK accountAssociatedServiceParamPK) {
        this.accountAssociatedServiceParamPK = accountAssociatedServiceParamPK;
    }

}

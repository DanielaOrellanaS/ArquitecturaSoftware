package com.banquito.corepasivos.account.model;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account_asso_service_param")
public class AccountAssociatedServiceParam {

    @EmbeddedId
    private AccountAssociatedServicePK pk;

    @Column(name = "status", length = 3, nullable = false)
    private String status;

    @Column(name = "text_value", length = 128, nullable = true)
    private String textValue;

    @Column(name = "date_value", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dateValue;

    @Column(name = "number_value",  nullable = true)
    private BigDecimal numberValue;

    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Column(name = "end_date",  nullable = true)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public AccountAssociatedServiceParam(AccountAssociatedServicePK pk) {
        this.pk = pk;
    }
}
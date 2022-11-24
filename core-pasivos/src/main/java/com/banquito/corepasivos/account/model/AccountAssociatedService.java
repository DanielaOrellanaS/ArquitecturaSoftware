package com.banquito.corepasivos.account.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ACCOUNT_ASSOCIATED_SERVICE")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccountAssociatedService {

    @EmbeddedId
    private AccountAssociatedService pk;

    @Column(name = "STATUS", nullable = false, length = 3)
    private String status;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public AccountAssociatedService(AccountAssociatedService pk, String status, Date startDate, Date endDate) {
        this.pk = pk;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}

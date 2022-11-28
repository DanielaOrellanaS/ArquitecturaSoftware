package com.banquito.corepasivos.account.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account_associated_service")
public class AccountAssociatedService {

    @EmbeddedId
    private AccountAssociatedServicePK pk;

    @Column (name = "status", length = 3, nullable = false)
    private String status;

    @Column(name="start_date", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    // private Timestamp starDate;
    private Date starDate;
    
    @Column(name="end_date", nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    // private Timestamp endDate;
    private Date endDate;

    
    public AccountAssociatedService(AccountAssociatedServicePK pk) {
        this.pk = pk;
    }
}

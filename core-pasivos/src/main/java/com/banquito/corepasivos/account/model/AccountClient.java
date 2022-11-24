package com.banquito.corepasivos.account.model;

import java.io.Serializable;
import java.security.Timestamp;
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

@Table(name="ACCOUNT_CLIENT")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class AccountClient implements Serializable{
    
    @EmbeddedId
    private AccountClientPK pk;
    
    @Column(name="CREATE_DATE", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createDate;

    public AccountClient (AccountClientPK pk, Timestamp createDate){
        this.pk = pk;
        this.createDate = createDate;
    }

    

    
}

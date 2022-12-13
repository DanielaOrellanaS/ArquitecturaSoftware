package com.banquito.corepasivos.account.model;

import com.banquito.corepasivos.client.model.Client;
import lombok.Data;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account_client")
public class AccountClient implements Serializable {

    @EmbeddedId
    @Include
    private AccountClientPK pk;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "status", length = 3, nullable = false)
    private String status;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_local_account", referencedColumnName = "code_local_account", insertable = false, updatable = false),
            @JoinColumn(name = "code_international_account", referencedColumnName = "code_international_account", insertable = false, updatable = false)
    })
    private Account account;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "identification_type", referencedColumnName = "identification_type", insertable = false, updatable = false),
            @JoinColumn(name = "identification", referencedColumnName = "identification", insertable = false, updatable = false)
    })
    private Client client;

    public AccountClient(AccountClientPK pk) {
        this.pk = pk;
    }

}

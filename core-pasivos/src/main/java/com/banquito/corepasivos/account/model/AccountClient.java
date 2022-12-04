package com.banquito.corepasivos.account.model;

import java.util.Date;

import javax.persistence.*;

import com.banquito.corepasivos.client.model.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account_client")
public class AccountClient {

    @EmbeddedId
    private AccountClientPK pk;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "status", length = 3, nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "code_local_account", insertable = false, updatable = false),
            @JoinColumn(name = "code_international_account", insertable = false, updatable = false),
    })
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "identification_type", insertable = false, updatable = false),
            @JoinColumn(name = "identification", insertable = false, updatable = false),
    })
    private Client client;

    public AccountClient(AccountClientPK pk) {
        this.pk = pk;
    }

}

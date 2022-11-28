package com.banquito.corepasivos.account.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;

import javax.persistence.*;

import com.banquito.corepasivos.client.model.Client;
import com.banquito.corepasivos.product.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNT_CLIENT")
public class AccountClient {

    @EmbeddedId
    private AccountClientPK pk;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_account", referencedColumnName = "code_account", insertable = false, updatable = false),
            @JoinColumn(name = "code_local_account", referencedColumnName = "code_local_account", insertable = false, updatable = false),
            @JoinColumn(name = "code_international_account", referencedColumnName = "code_international_account", insertable = false, updatable = false),
    })
    private Account account;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_client", referencedColumnName = "code_client", insertable = false, updatable = false),
            @JoinColumn(name = "identification_type", referencedColumnName = "identification_type", insertable = false, updatable = false),
            @JoinColumn(name = "identification", referencedColumnName = "identification", insertable = false, updatable = false),
    })
    private Client client;

    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "STATUS", length = 3, nullable = false)
    private String status;

    public AccountClient(AccountClientPK pk) {
        this.pk = pk;
    }

}

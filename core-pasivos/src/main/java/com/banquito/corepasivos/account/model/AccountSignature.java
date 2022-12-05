package com.banquito.corepasivos.account.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.banquito.corepasivos.client.model.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account_signature")
public class AccountSignature implements Serializable {
    @EmbeddedId
    private AccountSignaturePK pk;

    @Column(name = "signature_reference", length = 2048, nullable = false)
    private String signatureReference;

    @Column(name = "role", length = 64, nullable = false)
    private String role;

    @Column(name = "status", length = 3, nullable = false)
    private String status;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = true)
    private Date endDate;

    @JsonBackReference(value = "account-accountSignature")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_local_account", referencedColumnName = "code_local_account", insertable = false, updatable = false),
            @JoinColumn(name = "code_international_account", referencedColumnName = "code_international_account", insertable = false, updatable = false),
    })
    private Account account;

    @JsonBackReference(value = "client-accountSignature")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "identification_type", referencedColumnName = "identification_type", insertable = false, updatable = false),
            @JoinColumn(name = "identification", referencedColumnName = "identification", insertable = false, updatable = false),
    })
    private Client client;

    public AccountSignature(AccountSignaturePK pk) {
        this.pk = pk;
    }
}

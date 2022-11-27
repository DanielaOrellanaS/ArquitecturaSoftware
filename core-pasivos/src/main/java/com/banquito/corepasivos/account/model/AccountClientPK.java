package com.banquito.corepasivos.account.model;

import java.io.Serializable;

import javax.persistence.JoinColumns;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.banquito.corepasivos.client.model.Client;

import lombok.Data;

@Data
@Embeddable
public class AccountClientPK implements Serializable {

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_account", referencedColumnName = "code_account"),
            @JoinColumn(name = "code_local_account", referencedColumnName = "code_local_account"),
            @JoinColumn(name = "code_international_account", referencedColumnName = "code_international_account")
    })
    private Account account;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_client", referencedColumnName = "code_client"),
            @JoinColumn(name = "identification_type", referencedColumnName = "identification_type"),
            @JoinColumn(name = "identification", referencedColumnName = "identification")
    })
    private Client client;
}

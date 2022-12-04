package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client_phone")
public class ClientPhone {

    @EmbeddedId
    private ClientPhonePK pk;

    @Column(name = "type", length = 3, nullable = false)
    private String type;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "identification_type", referencedColumnName = "identification_type", insertable = false, updatable = false),
            @JoinColumn(name = "identification", referencedColumnName = "identification", insertable = false, updatable = false),
    })
    private Client client;

    public ClientPhone(ClientPhonePK pk) {
        this.pk = pk;
    }
}

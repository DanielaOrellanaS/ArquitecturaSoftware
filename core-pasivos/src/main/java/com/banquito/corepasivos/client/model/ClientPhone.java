package com.banquito.corepasivos.client.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client_phone")
public class ClientPhone {
    @EmbeddedId
    private ClientPhonePK pk;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_client", referencedColumnName = "code_client", insertable = false, updatable = false),
            @JoinColumn(name = "identification_type", referencedColumnName = "identification_type", insertable = false, updatable = false),
            @JoinColumn(name = "identification", referencedColumnName = "identification", insertable = false, updatable = false),
    })
    private Client client;
    @Column(name = "type", length = 3, nullable = false)
    private String type;
    public ClientPhone(ClientPhonePK pk) {
        this.pk = pk;
    }
}
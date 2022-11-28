package com.banquito.corepasivos.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client_reference")
public class ClientReference {

    @EmbeddedId
    private ClientReferencePK pk;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "identification_type", referencedColumnName = "identification_type", insertable = false, updatable = false),
            @JoinColumn(name = "identification", referencedColumnName = "identification", insertable = false, updatable = false),
            @JoinColumn(name = "code_client", referencedColumnName = "code_client", insertable = false, updatable = false)
    })
    private Client client;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "phone", length = 16, nullable = false)
    private String phone;

    @Column(name = "related", length = 64, nullable = true)
    private String related;

    public ClientReference(ClientReferencePK pk) {
        this.pk = pk;
    }
}
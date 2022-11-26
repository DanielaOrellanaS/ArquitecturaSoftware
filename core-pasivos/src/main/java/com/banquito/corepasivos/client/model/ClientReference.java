package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CLIENT_REFERENCE")
@NoArgsConstructor
@Data
public class ClientReference {

    @EqualsAndHashCode.Include
    @EmbeddedId
    private ClientReferencePK clientReferencePK;
    @Column(name = "CODE_CLIENT", nullable = false)
    private Integer codeClient;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;
    @Column(name = "PHONE", length = 16, nullable = false)
    private String phone;
    @Column(name = "RELATED", length = 64, nullable = true)
    private String related;

    @ManyToOne
    @MapsId("IDENTIFICATION")
    private Client client;

    public ClientReference(ClientReferencePK clientReferencePK) {
        this.clientReferencePK = clientReferencePK;
    }
}

package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
    private ClientReferencePK key;
    @Column(name = "CODE_CLIENT", nullable = false)
    private Integer codeClient;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;
    @Column(name = "PHONE", length = 16, nullable = false)
    private String phone;
    @Column(name = "RELATED", length = 64, nullable = true)
    private String related;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "IDENTIFICATION", referencedColumnName = "IDENTIFICATION", insertable = false, updatable = false, nullable = true),
        @JoinColumn(name = "IDENTIFICATION_TYPE", referencedColumnName = "IDENTIFICATION_TYPE", insertable = false, updatable = false, nullable = true)
    })
    private Client client;

    public ClientReference(ClientReferencePK key) {
        this.key = key;
    }
}

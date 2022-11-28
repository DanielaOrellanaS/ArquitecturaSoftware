package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client_reference")
@NoArgsConstructor
@Data
public class ClientReference {

    @EmbeddedId
    private ClientReferencePK pk;

    @Column(name = "code_client", nullable = false)
    private Integer codeClient;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "phone", length = 16, nullable = false)
    private String phone;

    @Column(name = "related", length = 64, nullable = true)
    private String related;

    public ClientReference(ClientReferencePK pk) {
        this.pk = pk;
    }

    /*
     * @ManyToOne
     * 
     * @JoinColumns({
     * 
     * @JoinColumn(name = "IDENTIFICATION", referencedColumnName = "IDENTIFICATION",
     * insertable = false, updatable = false, nullable = true),
     * 
     * @JoinColumn(name = "IDENTIFICATION_TYPE", referencedColumnName =
     * "IDENTIFICATION_TYPE", insertable = false, updatable = false, nullable =
     * true)
     * })
     * private Client client;
     */

}

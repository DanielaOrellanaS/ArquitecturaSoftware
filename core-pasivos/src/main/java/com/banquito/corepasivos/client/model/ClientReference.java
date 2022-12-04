package com.banquito.corepasivos.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client_reference")
public class ClientReference {

    @Id
    @Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code_reference", nullable = false)
    private Integer codeReference;

    @Column(name = "identification_type", length = 3, nullable = false)
    private String identificationtype;

    @Column(name = "identification", length = 20, nullable = false)
    private String identification;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "phone", length = 16, nullable = false)
    private String phone;

    @Column(name = "related", length = 64, nullable = true)
    private String related;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "identification_type", referencedColumnName = "identification_type", insertable = false, updatable = false),
            @JoinColumn(name = "identification", referencedColumnName = "identification", insertable = false, updatable = false),
    })
    private Client client;

    public ClientReference(Integer codeReference) {
        this.codeReference = codeReference;
    }
}
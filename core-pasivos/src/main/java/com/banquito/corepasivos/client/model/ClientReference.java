package com.banquito.corepasivos.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client_reference")
public class ClientReference implements Serializable {

    @Id
    @Include
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "BOOK_SEQ")
    @SequenceGenerator(sequenceName = "client_reference_code_reference_seq",allocationSize = 1, name = "BOOK_SEQ")
    @Column(name = "code_reference", nullable = true)
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

    @JsonBackReference(value = "client-clientReference")
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
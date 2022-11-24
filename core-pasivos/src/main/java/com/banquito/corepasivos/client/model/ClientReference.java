package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CLIENT_REFERENCE")
public class ClientReference {
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_REFERENCE", nullable = false)
    private Integer codeReference;
    @ManyToOne
    @JoinColumn(name = "CODE_CLIENT", referencedColumnName = "CODE_CLIENT", length = 4, nullable = false)
    private Client codeClient;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;
    @Column(name = "PHONE", length = 16, nullable = false)
    private String phone;
    @Column(name = "RELATED", length = 64, nullable = false)
    private String related;

    public ClientReference(Integer codeReference) {
        this.codeReference = codeReference;
    }
}

package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @EmbeddedId
    @Column(name = "CODE_REFERENCE", length = 8, nullable = false)
    private Integer codeReference;
    @Column(name = "CODE_CLIENT", length = 4, nullable = false)
    private Integer codeClient;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;
    @Column(name = "PHONE", length = 16, nullable = false)
    private String phone;
    @Column(name = "RELATED", length = 64, nullable = false)
    private String related;

    public ClientReference(String codeReference) {
        this.codeReference = codeReference;
    }
}

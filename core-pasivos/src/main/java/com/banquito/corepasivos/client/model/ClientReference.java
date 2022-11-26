package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @Id
    @Column(name = "CODE_REFERENCE", nullable = false)
    private Integer codeReference;
    @Column(name = "IDENTIFICATION_TYPE", length = 3, nullable = false)
    private String identificationType;
    @Column(name = "IDENTIFICATION", length = 20, nullable = false)
    private String identification;
    @Column(name = "CODE_CLIENT", nullable = false)
    private Integer codeClient;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;
    @Column(name = "PHONE", length = 16, nullable = false)
    private String phone;
    @Column(name = "RELATED", length = 64, nullable = true)
    private String related;

    public ClientReference(Integer codeReference) {
        this.codeReference = codeReference;
    }
}

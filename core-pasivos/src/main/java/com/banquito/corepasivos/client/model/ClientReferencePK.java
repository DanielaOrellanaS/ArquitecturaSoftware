package com.banquito.corepasivos.client.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class ClientReferencePK implements Serializable {
    @Column(name = "CODE_REFERENCE", nullable = false)
    private Integer code;
    @Column(name = "IDENTIFICATION_TYPE", length = 3, nullable = false)
    private String identificationtype;
    @Column(name = "IDENTIFICATION", length = 20, nullable = false)
    private String identification;
}

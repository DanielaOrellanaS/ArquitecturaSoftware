package com.banquito.corepasivos.client.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ClientReferencePK implements Serializable {

    @Column(name = "code_reference", nullable = false)
    private Integer code;

    @Column(name = "identification_type", length = 3, nullable = false)
    private String identificationtype;

    @Column(name = "identification", length = 20, nullable = false)
    private String identification;
}
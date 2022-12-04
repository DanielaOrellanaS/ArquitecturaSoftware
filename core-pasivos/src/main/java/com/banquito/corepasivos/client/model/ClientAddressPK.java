package com.banquito.corepasivos.client.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class ClientAddressPK implements Serializable {

    @Column(name = "identification_type", length = 3, nullable = false)
    private String identificationType;

    @Column(name = "identification", length = 20, nullable = false)
    private String identification;

    @Column(name = "code_location", nullable = false)
    private Integer codeLocation;
}
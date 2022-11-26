package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class ClientAddressPK {
    @Column(name = "code_address", nullable = false)
    private Integer codeAddress;
    @Column(name = "code_client", nullable = false)
    private Integer codeClient;
    @Column(name = "identification_type", length = 3, nullable = false)
    private String identificationType;
    @Column(name = "identification", length = 20, nullable = false)
    private String identification;
    @Column(name = "code_location", nullable = false)
    private Integer codeLocation;
}

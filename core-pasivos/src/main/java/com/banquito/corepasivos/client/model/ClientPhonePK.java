package com.banquito.corepasivos.client.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class ClientPhonePK implements Serializable {

    @Column(name = "phone_number", length = 16, nullable = false)
    private String phoneNumber;

    @Column(name = "code_client", nullable = false)
    private Integer codeClient;

    @Column(name = "identification_type", length = 3, nullable = false)
    private String identificationType;

    @Column(name = "identification", length = 20, nullable = false)
    private String identification;
}

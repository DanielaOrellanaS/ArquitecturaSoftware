package com.banquito.corepasivos.client.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
public class ClientPK implements Serializable {

    @Column(name = "code_client", nullable = false)
    private Integer codeClient;

    @Column(name = "identification_type", length = 3, nullable = false)
    private String identificationType;

    @Column(name = "identification", length = 20, nullable = false)
    private String identification;
}

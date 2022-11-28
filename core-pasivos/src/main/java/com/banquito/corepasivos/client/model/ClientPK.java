package com.banquito.corepasivos.client.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
public class ClientPK implements Serializable {

    @Column(name = "CODE_CLIENT", nullable = false)
    private Integer codeClient;

    @Column(name = "IDENTIFICATION_TYPE", length = 3, nullable = false)
    private String identificationType;

    @Column(name = "IDENTIFICATION", length = 20, nullable = false)
    private String identification;
}

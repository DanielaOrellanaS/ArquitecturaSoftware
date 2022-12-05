package com.banquito.corepasivos.client.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
public class ClientPK implements Serializable {

    @Column(name = "identification_type", length = 3, nullable = false)
    private String identificationType;

    @Column(name = "identification", length = 20, nullable = false)
    private String identification;
}

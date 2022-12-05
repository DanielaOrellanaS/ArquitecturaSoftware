package com.banquito.corepasivos.general.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class StructureEntityPK implements Serializable {

    @Column(name = "code_country", length = 2, nullable = false)
    private String codeCountry;

    @Column(name = "level", nullable = false)
    private Integer level;
}

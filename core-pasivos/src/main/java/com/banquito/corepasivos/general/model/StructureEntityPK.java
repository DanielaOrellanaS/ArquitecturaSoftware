package com.banquito.corepasivos.general.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
public class StructureEntityPK implements Serializable {

    @Column(name = "code_country", length = 2, nullable = false)
    private String codeCountry;

    @Column(name = "geo_level", scale = 2, precision = 0, nullable = false)
    private BigDecimal geoLevel;
}

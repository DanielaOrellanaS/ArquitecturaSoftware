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
public class LocationEntityPK implements Serializable {

    @Column(name = "code_location", nullable = false)
    private Integer codeLocation;

    @Column(name = "code_location_parent", nullable = false)
    private Integer codeLocationParent;

    @Column(name = "level", nullable = false)
    private BigDecimal level;

    @Column(name = "code_country", length = 2, nullable = false)
    private String codeCountry;
}

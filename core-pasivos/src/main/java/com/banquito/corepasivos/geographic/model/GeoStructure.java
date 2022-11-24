package com.banquito.corepasivos.geographic.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "GEO_STRUCTURE")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class GeoStructure {
    @EqualsAndHashCode.Include
    @Column(name = "GEO_LEVEL", nullable = false, scale = 2)
    private BigDecimal  geoLevel;

    @ManyToOne
    @JoinColumn(name = "CODE_COUNTRY", referencedColumnName = "CODE_COUNTRY", nullable = false)
    private String codeCountry;

    @Column(name = "NAME", nullable = false, length = 64)
    private String name;

    public GeoStructure(BigDecimal geoLevel) {
        this.geoLevel = geoLevel;
    }
}

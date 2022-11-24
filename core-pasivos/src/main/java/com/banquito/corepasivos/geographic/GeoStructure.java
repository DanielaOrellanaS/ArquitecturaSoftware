package com.banquito.corepasivos.geographic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "GEO_STRUCTURE")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class GeoStructure {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "GEO_LEVEL", nullable = false, scale = 2, precision = 0)
    private Double  geoLevel;

    @ManyToOne
    @JoinColumn(name = "CODE_COUNTRY", referencedColumnName = "CODE_COUNTRY", nullable = false)
    private String codeCountry;

    @Column(name = "NAME", nullable = false, length = 64)
    private String name;

    public Product(String geoLevel) {
        this.geoLevel = geoLevel;
    }
}

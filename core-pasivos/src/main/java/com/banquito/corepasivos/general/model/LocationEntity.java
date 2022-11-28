package com.banquito.corepasivos.general.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "location_entity")
@Data
@NoArgsConstructor
public class LocationEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_location", nullable = false)
    private Integer codeLocation;
    @Column(name = "code_location_parent", nullable = false)
    private Integer codeLocationParent;
    @Column(name = "level", nullable = false)
    private Integer level;
    @Column(name = "code_country", length = 2, nullable = false)
    private String codeCountry;
    @Column(name = "name", length = 64, nullable = false)
    private String name;
    @Column(name = "phone_code_area", length = 2, nullable = false)
    private String phoneCodeArea;
    @Column(name = "zip_code", length = 16, nullable = false)
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "code_location_parent", referencedColumnName = "code_location", insertable = false, updatable = false, nullable = true)
    private LocationEntity locationEntity;

    @ManyToOne
    @JoinColumn(name = "level", referencedColumnName = "geo_level", insertable = false, updatable = false, nullable = true)
    private StructureEntity structureEntity;

    @ManyToOne
    @JoinColumn(name = "code_country", referencedColumnName = "code_country", insertable = false, updatable = false, nullable = true)
    private CountryEntity countryEntity;

    public LocationEntity(Integer codeLocation) {
        this.codeLocation = codeLocation;
    }
}
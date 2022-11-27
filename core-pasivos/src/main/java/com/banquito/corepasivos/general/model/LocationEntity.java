package com.banquito.corepasivos.general.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LOCATION_ENTITY")
@Data
@NoArgsConstructor
public class LocationEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE_LOCATION", nullable = false)
    private Integer codeLocation;
    @Column(name = "CODE_LOCATION_PARENT", nullable = false)
    private Integer codeLocationParent;
    @Column(name = "LEVEL", nullable = false)
    private Integer level;
    @Column(name = "CODE_COUNTRY", length = 2, nullable = false)
    private String codeCountry;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;
    @Column(name = "PHONE_CODE_AREA", length = 2, nullable = false)
    private String phoneCodeArea;
    @Column(name = "ZIP_CODE", length = 16, nullable = false)
    private String zipCode;

    public LocationEntity(Integer codeLocation) {
        this.codeLocation = codeLocation;
    }
}
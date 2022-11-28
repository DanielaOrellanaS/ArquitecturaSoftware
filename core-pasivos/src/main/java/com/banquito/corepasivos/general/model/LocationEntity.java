package com.banquito.corepasivos.general.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "location_entity")
@Data
@NoArgsConstructor
public class LocationEntity {

    @EmbeddedId
    private LocationEntityPK pk;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "phone_code_area", length = 2, nullable = false)
    private String phoneCodeArea;

    @Column(name = "zip_code", length = 16, nullable = false)
    private String zipCode;
    /*
     * @ManyToOne
     * 
     * @JoinColumns({
     * 
     * @JoinColumn(name = "code_country", referencedColumnName = "code_country",
     * insertable = false, updatable = false, nullable = true),
     * })
     * private CountryEntity countryEntity;
     * 
     * @ManyToOne
     * 
     * @JoinColumns({
     * 
     * @JoinColumn(name = "geo_level", referencedColumnName = "geo_level",
     * insertable = false, updatable = false, nullable = true),
     * })
     * private StructureEntity structureEntity;
     */
}

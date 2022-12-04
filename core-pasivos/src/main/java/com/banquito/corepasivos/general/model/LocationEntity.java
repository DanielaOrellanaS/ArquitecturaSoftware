package com.banquito.corepasivos.general.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

@Data
@NoArgsConstructor
@Entity
@Table(name = "location_entity")
public class LocationEntity {

    @EmbeddedId
    @Include
    private LocationEntityPK pk;

    @Column(name = "name", length = 64, nullable = true)
    private String name;

    @Column(name = "phone_code_area", length = 2, nullable = true)
    private String phoneCodeArea;

    @Column(name = "zip_code", length = 16, nullable = true)
    private String zipCode;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_country", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "level", nullable = false, insertable = false, updatable = false)
    })
    private StructureEntity structureEntity;

    @ManyToOne
    @JoinColumn(name = "code_country", nullable = false, insertable = false, updatable = false)
    private CountryEntity countryEntity;

    @OneToMany(mappedBy = "location_entity")
    private List<Holiday> holidays;

    public LocationEntity(LocationEntityPK pk) {
        this.pk = pk;
    }

}

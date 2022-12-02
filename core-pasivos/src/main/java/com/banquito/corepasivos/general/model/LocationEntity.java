package com.banquito.corepasivos.general.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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

    public LocationEntity(LocationEntityPK pk) {
        this.pk = pk;
    }

}

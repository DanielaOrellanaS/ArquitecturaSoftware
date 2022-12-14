package com.banquito.corepasivos.general.model;

import lombok.Data;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "structure_entity")
public class StructureEntity {

    @EmbeddedId
    @Include
    private StructureEntityPK pk;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    /*
     * @JsonBackReference(value = "country-structureEntity")
     * 
     * @ManyToOne
     * 
     * @JoinColumn(name = "code_country", referencedColumnName = "code_country",
     * insertable = false, updatable = false)
     * private CountryEntity countryEntity;
     * 
     * @JsonManagedReference(value = "structureEntity-locationEntity")
     * 
     * @OneToMany(mappedBy = "structureEntity")
     * private List<LocationEntity> locationEntities;
     */

    public StructureEntity(StructureEntityPK pk) {
        this.pk = pk;
    }

}

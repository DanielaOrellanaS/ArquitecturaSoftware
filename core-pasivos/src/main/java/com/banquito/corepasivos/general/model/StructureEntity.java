package com.banquito.corepasivos.general.model;

import java.io.Serializable;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 24d9e645cd043f2fa3b75fda16c5e459ff708104

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

@Data
@NoArgsConstructor
@Entity
@Table(name = "structure_entity")
public class StructureEntity implements Serializable {

    @EmbeddedId
    @Include
    private StructureEntityPK pk;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    // @ManyToOne
    // @JoinColumn(name = "code_country", nullable = false, insertable = false,
    // updatable = false)
    // private CountryEntity countryEntity;

    /*
     * @JsonManagedReference
     * 
     * @OneToMany(mappedBy = "structure_entity")
     * private List<LocationEntity> locationEntities;
     */

    public StructureEntity(StructureEntityPK pk) {
        this.pk = pk;
    }
}

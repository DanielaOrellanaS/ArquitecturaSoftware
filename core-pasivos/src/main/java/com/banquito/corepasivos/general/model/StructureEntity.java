package com.banquito.corepasivos.general.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "structure_entity")
@Data
@NoArgsConstructor
public class StructureEntity {

    @EmbeddedId
    private StructureEntityPK pk;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "code_country", referencedColumnName = "code_country", insertable = false, updatable = false, nullable = true)
    private CountryEntity countryEntity;

    public StructureEntity(StructureEntityPK pk) {
        this.pk = pk;
    }
}

package com.banquito.corepasivos.general.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "STRUCTURE_ENTITY")
@Data
@NoArgsConstructor
public class StructureEntity {
    @EqualsAndHashCode.Include
    @EmbeddedId
    private StructureEntityPK key;

    @Column(name = "NAME", length = 64, nullable = false)
    private String name;
}

package com.banquito.corepasivos.general.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "country_entity")
public class CountryEntity {

    @Id
    @Include
    @Column(name = "code_country", length = 2, nullable = false)
    private String codeCountry;

    @Column(name = "code_phone", length = 4, nullable = false)
    private String codePhone;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "countryEntity")
    private List<LocationEntity> locationEntities;

    @JsonManagedReference
    @OneToMany(mappedBy = "countryEntity")
    private List<StructureEntity> structureEntities;

    public CountryEntity(String codeCountry) {
        this.codeCountry = codeCountry;
    }

}

package com.banquito.corepasivos.general.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

@Data
@NoArgsConstructor
@Entity
@Table(name = "country_entity")
public class CountryEntity implements Serializable {
    @Id
    @Include
    @Column(name = "code_country", length = 2, nullable = false)
    private String codeCountry;

    @Column(name = "code_phone", length = 4, nullable = false)
    private String codePhone;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    /*
     * @JsonManagedReference
     * 
     * @OneToMany(mappedBy = "country_entity")
     * private List<LocationEntity> locationEntities;
     */

    public CountryEntity(String codeCountry) {
        this.codeCountry = codeCountry;
    }
}

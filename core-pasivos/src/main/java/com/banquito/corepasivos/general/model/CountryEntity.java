package com.banquito.corepasivos.general.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COUNTRY_ENTITY")
@Data
@NoArgsConstructor
public class CountryEntity {
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "CODE_COUNTRY", length = 2, nullable = false)
    private String codeCountry;
    @Column(name = "CODE_PHONE", length = 4, nullable = false)
    private String codePhone;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;

    public CountryEntity(String codeCountry) {
        this.codeCountry = codeCountry;
    }
}

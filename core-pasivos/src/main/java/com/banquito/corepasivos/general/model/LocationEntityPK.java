package com.banquito.corepasivos.general.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
@Embeddable
public class LocationEntityPK implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code_location", nullable = false)
    private Integer codeLocation;

    @Column(name = "code_location_parent", nullable = true)
    private Integer codeLocationParent;

    @Column(name = "level", nullable = false)
    private Integer level;

    @Column(name = "code_country", length = 2, nullable = false)
    private String codeCountry;
}

package com.banquito.corepasivos.general.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "location_entity")
public class LocationEntity {

    @Id
    @Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code_location", nullable = false)
    private Integer codeLocation;

    @Column(name = "code_location_parent", nullable = false)
    private Integer codeLocationParent;

    @Column(name = "level", length = 2, nullable = false)
    private Integer level;

    @Column(name = "code_country_structure", length = 2, nullable = false)
    private String codeCountryStructure;

    @Column(name = "code_country_entity", length = 2, nullable = false)
    private String codeCountryEntity;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "phone_code_area", length = 2, nullable = false)
    private String phoneCodeArea;

    @Column(name = "zip_code", length = 16, nullable = false)
    private String zipCode;

    @JsonBackReference
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "level", referencedColumnName = "level", insertable = false, updatable = false),
            @JoinColumn(name = "code_country_structure", referencedColumnName = "code_country", insertable = false, updatable = false)
    })
    private StructureEntity structureEntity;

    @JsonBackReference
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_country_entity", referencedColumnName = "code_country", insertable = false, updatable = false)
    })
    private CountryEntity countryEntity;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "locationEntity")
    private List<Holiday> holidayList;

    public LocationEntity(Integer codeLocation) {
        this.codeLocation = codeLocation;
    }
}

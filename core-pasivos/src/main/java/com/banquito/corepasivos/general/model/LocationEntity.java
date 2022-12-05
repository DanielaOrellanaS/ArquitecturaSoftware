package com.banquito.corepasivos.general.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.banquito.corepasivos.client.model.ClientAddress;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

@Data
@NoArgsConstructor
@Entity
@Table(name = "location_entity")
public class LocationEntity implements Serializable{

    @Id
    @Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code_location", nullable = false)
    private Integer codeLocation;

    @Column(name = "code_location_parent", nullable = true)
    private Integer codeLocationParent;

    @Column(name = "level", nullable = false)
    private Integer level;

    @Column(name = "code_country", length = 2, nullable = false)
    private String codeCountry;

    @Column(name = "name", length = 64, nullable = true)
    private String name;

    @Column(name = "phone_code_area", length = 2, nullable = true)
    private String phoneCodeArea;

    @Column(name = "zip_code", length = 16, nullable = true)
    private String zipCode;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_country", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "level", nullable = false, insertable = false, updatable = false)
    })
    private StructureEntity structureEntity;

    @ManyToOne
    @JoinColumn(name = "code_country", nullable = false, insertable = false, updatable = false)
    private CountryEntity countryEntity;

    @OneToMany(mappedBy = "location_entity")
    private List<Holiday> holidays;

    @OneToMany(mappedBy = "location_entity")
    private List<ClientAddress> clientAddresses;

    public LocationEntity(Integer codeLocation) {
        this.codeLocation = codeLocation;
    }
}

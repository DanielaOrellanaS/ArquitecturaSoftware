package com.banquito.corepasivos.geographic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "GEO_LOCATION")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class GeoLocation {
    
    @EqualsAndHashCode.Include
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CODE_LOCATION", nullable = false)
    private Integer codeLocation;

    @ManyToOne
    @JoinColumn(name = "GEO_CODE_LOCATION_PARENT", referencedColumnName = "CODE_LOCATION")    
    @Column(name = "GEO_CODE_LOCATION_PARENT", nullable = true)
    private GeoLocation codeLocationParent;

    @OneToMany(mappedBy = "codeLocationParent")
    
    @ManyToOne
    @Column(name = "CODE_COUNTRY", length = 2, nullable = false)
    private GeoCountry codeCountry;

    @Column(name = "GEO_LEVEL", length = 2, nullable = false)
    private Integer level;

    @Column(name = "NAME", length = 64, nullable = true)
    private String name;

    @Column(name = "PHONE_CODE_AREA", length = 2, nullable = true)
    private String phoneCodeArea;

    @Column(name = "ZIP_CODE", length = 16, nullable = true)
    private String zipCode;

    public GeoLocation (Integer codeLocation) {
		this.codeLocation = codeLocation;
	}
}

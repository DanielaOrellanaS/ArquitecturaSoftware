package com.banquito.corepasivos.geographic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "GEO_LOCATION")
@Data
@NoArgsConstructor
public class GeoLocation {
    
    @EqualsAndHashCode.Include
	@Id
	@Column(name = "CODE_LOCATION", length = 5, nullable = false)
    private Integer codeLocation;

    @Column(name = "GEO_CODE_LOCATION_PARENT", length = 4)
    private GeoLocation codeLocationParent;

    @Column(name = "CODE_COUNTRY", length = 2, nullable = false)
    private GeoCountry codeCountry;

    @Column(name = "GEO_LEVEL", length = 2, nullable = false)
    private Integer level;

    @Column(name = "NAME", length = 64)
    private String name;

    @Column(name = "PHONE_CODE_AREA", length = 2)
    private String phoneCodeArea;

    @Column(name = "ZIP_CODE", length = 16)
    private String zipCode;

    public GeoLocation (Integer codeLocation) {
		this.codeLocation = codeLocation;
	}
}

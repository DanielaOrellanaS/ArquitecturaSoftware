package com.banquito.corepasivos.geographic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "GEO_COUNTRY")
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class GeoCountry {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "CODE_COUNTRY", length = 2, nullable = false)
	private String codeCountry;

	@Column(name = "CODE_PHONE", length = 3, nullable = false)
	private String codePhone;

	@Column(name = "NAME", length = 64, nullable = false)
	private String name;

	public GeoCountry(String codeCountry) {
		this.codeCountry = codeCountry;
	}
}

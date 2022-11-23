package com.banquito.corepasivos.geographic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "GEO_COUNTRY")
@Getter
@Setter
@NoArgsConstructor
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

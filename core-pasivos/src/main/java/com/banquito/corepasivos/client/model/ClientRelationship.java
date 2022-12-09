package com.banquito.corepasivos.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client_relationship")
public class ClientRelationship implements Serializable {

	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_relationship", nullable = false)
	private Integer codeRelationship;

	@Column(name = "identification_type", length = 3, nullable = false)
	private String identificationType;

	@Column(name = "identification", length = 20, nullable = false)
	private String identification;

	@Column(name = "cli_identification_type", length = 3, nullable = false)
	private String cliIdentificationType;

	@Column(name = "cli_identification", length = 20, nullable = false)
	private String cliIdentification;

	@Column(name = "relationship_type", length = 32, nullable = false)
	private String relationshiptype;

	@Column(name = "start_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", nullable = false)
	private Date endDate;

	public ClientRelationship(Integer codeRelationship) {
		this.codeRelationship = codeRelationship;
	}
}
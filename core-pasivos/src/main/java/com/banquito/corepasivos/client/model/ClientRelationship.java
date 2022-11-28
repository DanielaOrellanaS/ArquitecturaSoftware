package com.banquito.corepasivos.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client_relationship")
public class ClientRelationship {

	@Id
	@Column(name = "code_relationship", nullable = false)
	private Integer codeRelationship;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "code_client", referencedColumnName = "code_client", insertable = false, updatable = false),
			@JoinColumn(name = "identification_type", referencedColumnName = "identification_type", insertable = false, updatable = false),
			@JoinColumn(name = "identification", referencedColumnName = "identification", insertable = false, updatable = false),
	})
	private Client client;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "code_client_relationship", referencedColumnName = "code_client_relationship", insertable = false, updatable = false),
			@JoinColumn(name = "cli_identification_type", referencedColumnName = "cli_identification_type", insertable = false, updatable = false),
			@JoinColumn(name = "cli_identification", referencedColumnName = "cli_identification", insertable = false, updatable = false),
	})
	private Client clientRelationship;

	@Column(name = "RELATIONSHIP_TYPE", length = 32, nullable = false)
	private String relationshipType;

	@Column(name = "START_DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name = "END_DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date endDate;

	public ClientRelationship(Integer codeRelationship) {
		this.codeRelationship = codeRelationship;
	}
}
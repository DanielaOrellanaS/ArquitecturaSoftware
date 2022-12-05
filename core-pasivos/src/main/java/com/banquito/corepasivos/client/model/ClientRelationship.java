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

	@Column(name = "relationship_type", length = 32, nullable = false)
	private String relationshipType;

	@Column(name = "start_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", nullable = false)
	private Date endDate;

	// @ManyToOne
	// @JoinColumns({
	// 		@JoinColumn(name = "identification_type", referencedColumnName = "identification_type", insertable = false, updatable = false),
	// 		@JoinColumn(name = "identification", referencedColumnName = "identification", insertable = false, updatable = false),
	// })
	// private Client client;

	// @ManyToOne
	// @JoinColumns({
	// 		@JoinColumn(name = "cli_identification_type", referencedColumnName = "identification_type", insertable = false, updatable = false),
	// 		@JoinColumn(name = "cli_identification", referencedColumnName = "identification", insertable = false, updatable = false),
	// })
	// private Client clientRelationship;

	public ClientRelationship(Integer codeRelationship) {
		this.codeRelationship = codeRelationship;
	}
}
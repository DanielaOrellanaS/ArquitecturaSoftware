package com.banquito.corepasivos.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client_relationship")
public class ClientRelationship implements Serializable {

	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "code_relationship", nullable = false)
	private Integer codeRelationship;

	@Column(name = "identification_type", nullable = false, length = 3)
	private String identificationType;

	@Column(name = "identification", nullable = false, length = 20)
	private String identification;

	@Column(name = "relationship_type", length = 32, nullable = false)
	private String relationshiptype;

	@Column(name = "start_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", nullable = false)
	private Date endDate;

	@JsonBackReference(value = "client-clientRelationship")
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "identification_type", referencedColumnName = "identification_type", insertable = false, updatable = false),
			@JoinColumn(name = "identification", referencedColumnName = "identification", insertable = false, updatable = false),
	})
	private Client client;

	public ClientRelationship(Integer codeRelationship) {
		this.codeRelationship = codeRelationship;
	}
}
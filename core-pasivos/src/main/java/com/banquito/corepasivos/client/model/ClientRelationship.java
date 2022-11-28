package com.banquito.corepasivos.client.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client_relationship")
@Data
@NoArgsConstructor
public class ClientRelationship {

    @Id
    @Column(name = "code_relationship", nullable = false)
    private Integer codeRelationship;

    @Column(name = "code_client", nullable = false)
    private Integer codeClient;

    @Column(name = "identification_type", length = 3, nullable = false)
    private String identificationType;

    @Column(name = "identification", length = 20, nullable = false)
    private String identification;

    @Column(name = "code_client_relationship", nullable = false)
    private Integer codeClientRelationship;

    @Column(name = "cli_identification_type", length = 3, nullable = false)
    private String cliIdentificationType;

    @Column(name = "cli_identification", length = 20, nullable = false)
    private String cliIdentification;

    @Column(name = "relationship_type", length = 32, nullable = false)
    private String relationshipType;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    public ClientRelationship(Integer codeRelationship) {
        this.codeRelationship = codeRelationship;
    }
}

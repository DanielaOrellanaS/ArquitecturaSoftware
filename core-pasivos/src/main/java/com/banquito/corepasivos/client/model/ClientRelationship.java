package com.banquito.corepasivos.client.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CLIENT_RELATIONSHIP")
@Data
@NoArgsConstructor
public class ClientRelationship {
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_RELATIONSHIP", nullable = false)
    private Integer codeRelationship;
    @Column(name = "CODE_CLIENT", nullable = false)
    private Integer codeClient;
    @Column(name = "IDENTIFICATION_TYPE", length = 3, nullable = false)
    private String identificationType;
    @Column(name = "IDENTIFICATION", length = 20, nullable = false)
    private String identification;
    @Column(name = "CODE_CLIENT_RELATIONSHIP", nullable = false)
    private Integer codeClientRelationship;
    @Column(name = "CLI_IDENTIFICATION_TYPE", length = 3, nullable = false)
    private String cliIdentificationType;
    @Column(name = "CLI_IDENTIFICATION", length = 20, nullable = false)
    private String cliIdentification;
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

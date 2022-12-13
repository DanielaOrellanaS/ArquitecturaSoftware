package com.banquito.corepasivos.client.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientRelationshipDto implements Serializable {
    private Integer codeRelationship;
    private String identificationType;
    private String identification;
    private String cliIdentificationType;
    private String cliIdentification;
    private String relationshipType;
    private Date startDate;
    private Date endDate;
}

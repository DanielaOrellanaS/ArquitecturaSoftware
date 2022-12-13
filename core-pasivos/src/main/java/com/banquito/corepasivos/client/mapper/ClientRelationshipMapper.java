package com.banquito.corepasivos.client.mapper;

import com.banquito.corepasivos.client.dto.ClientRelationshipDto;
import com.banquito.corepasivos.client.model.ClientRelationship;

public class ClientRelationshipMapper {
    public static ClientRelationship map(ClientRelationshipDto data) {
        ClientRelationship relationship = new ClientRelationship();
        relationship.setIdentification(data.getIdentification());
        relationship.setIdentificationtype(data.getIdentificationType());
        relationship.setCliIdentification(data.getCliIdentification());
        relationship.setCliIdentificationType(data.getCliIdentificationType());
        relationship.setRelationshiptype(data.getRelationshipType());
        relationship.setStartDate(data.getStartDate());
        relationship.setEndDate(data.getEndDate());
        return relationship;
    }

    public static ClientRelationshipDto map(ClientRelationship data) {
        ClientRelationshipDto dto = new ClientRelationshipDto();
        dto.setIdentification(data.getIdentification());
        dto.setIdentificationType(data.getIdentificationtype());
        dto.setCliIdentification(data.getCliIdentification());
        dto.setCliIdentificationType(data.getCliIdentificationType());
        dto.setRelationshipType(data.getRelationshiptype());
        dto.setStartDate(data.getStartDate());
        dto.setEndDate(data.getEndDate());
        return dto;
    }
}

package com.banquito.corepasivos.client.mapper;

import com.banquito.corepasivos.client.dto.request.RequestDtoClientReference;
import com.banquito.corepasivos.client.dto.response.ResponseDtoClientReference;
import com.banquito.corepasivos.client.model.ClientReference;

public class ClientReferenceMapper {
    public static ClientReference map(ResponseDtoClientReference data) {
        ClientReference reference = new ClientReference();
        reference.setCodeReference(data.getCodeReference());
        reference.setIdentification(data.getIdentification());
        reference.setIdentificationtype(data.getIdentificationType());
        reference.setName(data.getName());
        reference.setPhone(data.getPhone());
        reference.setRelated(data.getRelated());
        return reference;
    }

    public static RequestDtoClientReference map(ClientReference data) {
        RequestDtoClientReference dto = new RequestDtoClientReference();
        dto.setCodeReference(data.getCodeReference());
        dto.setIdentification(data.getIdentification());
        dto.setIdentificationType(data.getIdentificationtype());
        dto.setName(data.getName());
        dto.setPhone(data.getPhone());
        dto.setRelated(data.getRelated());
        return dto;
    }
}

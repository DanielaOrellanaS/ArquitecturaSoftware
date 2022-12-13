package com.banquito.corepasivos.client.mapper;

import com.banquito.corepasivos.client.dto.ClientPhoneDto;
import com.banquito.corepasivos.client.model.ClientPhone;
import com.banquito.corepasivos.client.model.ClientPhonePK;

public class ClientPhoneMapper {
    public static ClientPhone map(ClientPhoneDto data) {
        ClientPhone phone = new ClientPhone();
        ClientPhonePK pk = new ClientPhonePK();
        pk.setIdentification(data.getIdentification());
        pk.setIdentificationtype(data.getIdentificationType());
        pk.setPhonenumber(data.getPhoneNumber());
        phone.setPk(pk);
        phone.setType(data.getType());
        return phone;
    }

    public static ClientPhoneDto map(ClientPhone data) {
        ClientPhoneDto dto = new ClientPhoneDto();
        dto.setIdentification(data.getPk().getIdentification());
        dto.setIdentificationType(data.getPk().getIdentificationtype());
        dto.setPhoneNumber(data.getPk().getPhonenumber());
        dto.setType(data.getType());
        return dto;
    }
}

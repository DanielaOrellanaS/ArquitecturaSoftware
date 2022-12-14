package com.banquito.corepasivos.client.dto.response;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDtoClientPhone implements Serializable {
    private String phoneNumber;
    private String identificationType;
    private String identification;
    private String type;
}

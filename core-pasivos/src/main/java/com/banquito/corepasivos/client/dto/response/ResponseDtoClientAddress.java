package com.banquito.corepasivos.client.dto.response;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDtoClientAddress implements Serializable{
    private String identificationType;
    private String identification;
    private Integer codeLocation;
    private String addressLineOne;
    private String addressLineTwo;
    private String latitude;
    private String longitude;
}

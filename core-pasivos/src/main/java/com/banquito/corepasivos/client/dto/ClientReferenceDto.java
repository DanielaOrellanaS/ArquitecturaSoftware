package com.banquito.corepasivos.client.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientReferenceDto implements Serializable {
    private Integer codeReference;
    private String identificationType;
    private String identification;
    private String name;
    private String phone;
    private String related;
}

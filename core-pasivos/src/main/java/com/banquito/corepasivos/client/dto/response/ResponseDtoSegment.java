package com.banquito.corepasivos.client.dto.response;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDtoSegment implements Serializable {
    private String codeSegment;
    private String name;
    private String status;
}

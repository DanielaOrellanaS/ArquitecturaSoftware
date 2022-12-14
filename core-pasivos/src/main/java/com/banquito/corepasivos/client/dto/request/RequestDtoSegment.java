package com.banquito.corepasivos.client.dto.request;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestDtoSegment implements Serializable {
    private String codeSegment;
    private String name;
    private String status;
}

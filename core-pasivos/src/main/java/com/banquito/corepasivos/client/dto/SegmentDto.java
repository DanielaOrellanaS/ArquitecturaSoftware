package com.banquito.corepasivos.client.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SegmentDto implements Serializable {
    private String codeSegment;
    private String name;
    private String status;
}

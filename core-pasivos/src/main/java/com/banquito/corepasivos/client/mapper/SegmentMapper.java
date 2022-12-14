package com.banquito.corepasivos.client.mapper;

import com.banquito.corepasivos.client.dto.request.RequestDtoSegment;
import com.banquito.corepasivos.client.dto.response.ResponseDtoSegment;
import com.banquito.corepasivos.client.model.Segment;

public class SegmentMapper {
    public static Segment map(RequestDtoSegment data) {
        Segment segment = new Segment();
        segment.setCodeSegment(data.getCodeSegment());
        segment.setName(data.getName());
        segment.setStatus(data.getStatus());
        return segment;
    }

    public static ResponseDtoSegment map(Segment data) {
        ResponseDtoSegment dto = new ResponseDtoSegment();
        dto.setCodeSegment(data.getCodeSegment());
        dto.setName(data.getName());
        dto.setStatus(data.getStatus());
        return dto;
    }
}

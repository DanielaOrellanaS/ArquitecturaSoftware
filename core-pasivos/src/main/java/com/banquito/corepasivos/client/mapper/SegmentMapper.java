package com.banquito.corepasivos.client.mapper;

import com.banquito.corepasivos.client.dto.request.RequestDtoSegment;
import com.banquito.corepasivos.client.dto.response.ResponseDtoSegment;
import com.banquito.corepasivos.client.model.Segment;

public class SegmentMapper {
    public static Segment map(ResponseDtoSegment data) {
        Segment segment = new Segment();
        segment.setCodeSegment(data.getCodeSegment());
        segment.setName(data.getName());
        segment.setStatus(data.getStatus());
        return segment;
    }

    public static RequestDtoSegment map(Segment data) {
        RequestDtoSegment dto = new RequestDtoSegment();
        dto.setCodeSegment(data.getCodeSegment());
        dto.setName(data.getName());
        dto.setStatus(data.getStatus());
        return dto;
    }
}

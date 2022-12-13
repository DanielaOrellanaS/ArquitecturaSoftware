package com.banquito.corepasivos.client.mapper;

import com.banquito.corepasivos.client.dto.SegmentDto;
import com.banquito.corepasivos.client.model.Segment;

public class SegmentMapper {
    public static Segment map(SegmentDto data) {
        Segment segment = new Segment();
        segment.setCodeSegment(data.getCodeSegment());
        segment.setName(data.getName());
        segment.setStatus(data.getStatus());
        return segment;
    }

    public static SegmentDto map(Segment data) {
        SegmentDto dto = new SegmentDto();
        dto.setCodeSegment(data.getCodeSegment());
        dto.setName(data.getName());
        dto.setStatus(data.getStatus());
        return dto;
    }
}

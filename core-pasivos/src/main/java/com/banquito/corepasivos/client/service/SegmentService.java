package com.banquito.corepasivos.client.service;

import java.util.List;

import com.banquito.corepasivos.client.model.Segment;

public interface SegmentService {
    Segment createSegment(Segment segment);

    List<Segment> fetchSegments();

    Segment updateSegment(Segment segment, String codeSegment);

    void deleteSegment(String codeSegment);
}

package com.banquito.corepasivos.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.client.model.Segment;
import com.banquito.corepasivos.client.repository.SegmentRepository;

@Repository
public class SegmentServiceImpl implements SegmentService {

    @Autowired
    private SegmentRepository segmentRepository;

    @Override
    public Segment createSegment(Segment segment) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Segment> fetchSegments() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Segment updateSegment(Segment segment, String codeSegment) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteSegment(String codeSegment) {
        // TODO Auto-generated method stub

    }

}
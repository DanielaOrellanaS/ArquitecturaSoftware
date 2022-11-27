package com.banquito.corepasivos.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.corepasivos.client.model.Segment;
import com.banquito.corepasivos.client.repository.SegmentRepository;

@Repository
public class SegmentServiceImpl implements SegmentService {

    @Autowired
    private SegmentRepository segmentRepository;

    @Override
    @Transactional
    public Segment createSegment(Segment segment) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Segment> readSegments() {
        return this.segmentRepository.findAll();
    }

    @Override
    public Segment readSegmentByCode(String codeSegment) {
        return this.segmentRepository.findByCodeSegment(codeSegment).get(0);
    }

    @Override
    @Transactional
    public Segment updateSegment(Segment segment, String codeSegment) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public void deleteSegment(String codeSegment) {
        // TODO Auto-generated method stub

    }

}

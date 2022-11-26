package com.banquito.corepasivos.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.client.model.Segment;

public interface SegmentRepository extends JpaRepository<Segment, String> {
    List<Segment> findByCodeSegment(String codeSegment);
}

package com.banquito.corepasivos.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.model.Segment;
import com.banquito.corepasivos.client.service.SegmentService;

@RestController
@RequestMapping("/segments")
public class SegmentController {
    @Autowired
    private SegmentService segmentService;

    @GetMapping
    public List<Segment> readSegments() {
        return this.segmentService.readSegments();
    }

    @GetMapping("/{code}")
    public Segment readSegment(@PathVariable("code") String code) {
        return this.segmentService.readSegmentByCode(code);
    }
}

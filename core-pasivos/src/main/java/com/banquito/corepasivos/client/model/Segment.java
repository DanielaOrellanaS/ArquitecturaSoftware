package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "segment")
@NoArgsConstructor
@Data
public class Segment {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "code_segment", length = 16, nullable = false)
    private String codeSegment;
    @Column(name = "name", length = 64, nullable = false)
    private String name;
    @Column(name = "status", length = 3, nullable = false)
    private String status;

    public Segment(String codeSegment) {
        this.codeSegment = codeSegment;
    }
}
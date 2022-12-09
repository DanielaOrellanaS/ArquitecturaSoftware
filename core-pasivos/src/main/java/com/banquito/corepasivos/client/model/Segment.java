package com.banquito.corepasivos.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "segment")
public class Segment implements Serializable {

    @Id
    @Include
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

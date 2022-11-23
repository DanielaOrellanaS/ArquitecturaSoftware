package com.banquito.corepasivos.config.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "SEGMENT")
public class Segment {
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_SEGMENT", length = 16, nullable = false)
    private String codeSegment;
    @Column(name = "CODE_INTEREST_LOG", nullable = true)
    private Integer codeClient;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;
    @Column(name = "STATUS", length = 3, nullable = false)
    private String status;

    public Segment(String codeSegment) {
        this.codeSegment = codeSegment;
    }
}

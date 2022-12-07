package com.banquito.corepasivos.general.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class StructureEntityPK implements Serializable {
    @Column(name = "code_country", length = 2, nullable = false)
    private String codecountry;

    @Column(name = "level", length = 2, nullable = false)
    private Integer level;
}

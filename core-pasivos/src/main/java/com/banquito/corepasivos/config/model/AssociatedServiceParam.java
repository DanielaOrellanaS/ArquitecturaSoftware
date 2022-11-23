package com.banquito.corepasivos.config.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="ASSOCIATED_SERVICE_PARAM")
public class AssociatedServiceParam {

    @EqualsAndHashCode.Include
    @Id
    @Column(name="CODE_PARAM", length=16, nullable=false)
    private String codeParam;

    @ManyToOne
    @JoinColumn(name="CODE_ASSOCIATED_SERVICE", nullable=false)
    private AssociatedService codeAssociatedServiceParam;

    @Column(name="VALUE_TYPE", length=3, nullable=false)
    private String valueType;

    @Column(name="NAME", length=64, nullable=false)
    private String name;

    public AssociatedServiceParam(String codeParam) {
        this.codeParam = codeParam;
    }
}

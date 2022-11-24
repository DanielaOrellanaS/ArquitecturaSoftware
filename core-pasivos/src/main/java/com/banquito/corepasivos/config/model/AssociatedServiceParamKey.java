package com.banquito.corepasivos.config.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class AssociatedServiceParamKey implements Serializable {
    @EqualsAndHashCode.Include
    @Column(name="CODE_PARAM", length=16, nullable=false)
    private String codeParam;

    @ManyToOne
    @JoinColumn(name="CODE_ASSOCIATED_SERVICE", nullable=false)
    private AssociatedService codeAssociatedService;

    public AssociatedServiceParamKey(String codeParam, AssociatedService codeAssociatedService) {
        this.codeParam = codeParam;
        this.codeAssociatedService = codeAssociatedService;
    }
}

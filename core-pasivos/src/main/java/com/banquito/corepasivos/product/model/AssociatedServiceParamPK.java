package com.banquito.corepasivos.product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class AssociatedServiceParamPK implements Serializable {

    @Column(name = "code_param", length = 16, nullable = false)
    private String codeParam;

    @Column(name = "code_associated_service", length = 16, nullable = false)
    private String codeAssociatedService;
}

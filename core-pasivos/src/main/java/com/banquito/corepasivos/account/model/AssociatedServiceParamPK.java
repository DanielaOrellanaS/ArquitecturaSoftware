package com.banquito.corepasivos.account.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class AssociatedServiceParamPK implements Serializable {

    @Column(name = "CODE_PARAM", length = 16, nullable = false)
    private String codeParam;
    @Column(name = "CODE_ASSOCIATED_SERVICE", length = 16, nullable = false)
    private String codeAssociatedService;
}
